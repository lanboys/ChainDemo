package com.bing.lan.chain.web.adapter;

import com.bing.lan.chain.core.base.AbstractFilterChain;
import com.bing.lan.chain.core.base.Request;
import com.bing.lan.chain.core.base.Response;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;

/**
 * Created by 蓝兵 on 2019/7/5.
 */

public abstract class WebFilterChain extends AbstractFilterChain {

    protected FilterChain originChain;

    public WebFilterChain(String name, FilterChain originChain) {
        super(name);
        this.originChain = originChain;
    }

    public final void doFilter(Request request, Response response) throws IOException, ServletException {
        doWebFilter((RequestWrapper) request, (ResponseWrapper) response);
    }

    public abstract void doWebFilter(RequestWrapper requestWrapper, ResponseWrapper responseWrapper)
            throws IOException, ServletException;
}
