package com.bing.lan.chain.web.adapter;

import com.bing.lan.chain.core.base.AbstractFilter;
import com.bing.lan.chain.core.base.Chain;
import com.bing.lan.chain.core.base.Request;
import com.bing.lan.chain.core.base.Response;

/**
 * Created by 蓝兵 on 2019/7/7.
 */

public abstract class WebFilter extends AbstractFilter {

    public final void doFilter(Request request, Response response, Chain chain) throws Exception {
        doWebFilter((RequestWrapper) request, (ResponseWrapper) response, (WebChain) chain);
    }

    public abstract void doWebFilter(RequestWrapper requestWrapper, ResponseWrapper responseWrapper,
            WebChain webFilterChain) throws Exception;
}
