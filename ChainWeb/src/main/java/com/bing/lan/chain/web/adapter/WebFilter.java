package com.bing.lan.chain.web.adapter;

import com.bing.lan.chain.core.base.AbstractFilter;
import com.bing.lan.chain.core.base.FilterChain;
import com.bing.lan.chain.core.base.Request;
import com.bing.lan.chain.core.base.Response;

/**
 * Created by 蓝兵 on 2019/7/7.
 */

public abstract class WebFilter extends AbstractFilter {

    public void doFilter(Request request, Response response, FilterChain chain) throws Exception {
        doWebFilter((RequestWrapper) request, (ResponseWrapper) response, (WebFilterChain) chain);
    }

    public abstract void doWebFilter(RequestWrapper requestWrapper, ResponseWrapper responseWrapper,
            WebFilterChain webFilterChain) throws Exception;
}
