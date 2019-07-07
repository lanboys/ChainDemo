package com.bing.lan.chain.web;

import com.bing.lan.chain.web.adapter.RequestWrapper;
import com.bing.lan.chain.web.adapter.ResponseWrapper;
import com.bing.lan.chain.web.adapter.WebFilter;
import com.bing.lan.chain.web.adapter.WebFilterChain;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;

/**
 * Created by 蓝兵 on 2019/7/5.
 */

public class DelegatingChainProxy extends WebFilterChain {

    private int index = 0;

    public DelegatingChainProxy(String s, FilterChain originChain) {
        super(s, originChain);
    }

    public void doWebFilter(RequestWrapper requestWrapper, ResponseWrapper responseWrapper)
            throws IOException, ServletException {

        if (index < filters.size()) {
            try {
                index++;
                WebFilter filter = (WebFilter) filters.get(index - 1);
                filter.doFilter(requestWrapper, responseWrapper, this);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return;
        }

        System.out.println("doFilter(): filter chain finish");
        originChain.doFilter(requestWrapper.getOriginRequest(),
                responseWrapper.getOriginResponse());
    }
}
