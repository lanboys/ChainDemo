package com.bing.lan.chain.web.filter;

import com.bing.lan.chain.web.adapter.RequestWrapper;
import com.bing.lan.chain.web.adapter.ResponseWrapper;
import com.bing.lan.chain.web.adapter.WebFilter;
import com.bing.lan.chain.web.adapter.WebFilterChain;

/**
 * Created by 蓝兵 on 2019/7/7.
 */

public class AdviceFilter extends WebFilter {

    public final void doWebFilter(RequestWrapper requestWrapper, ResponseWrapper responseWrapper,
            WebFilterChain webFilterChain) throws Exception {
        Exception exception = null;
        try {
            boolean continueChain = preHandle(requestWrapper, responseWrapper);
            if (continueChain) {
                webFilterChain.doWebFilter(requestWrapper, responseWrapper);
            }
            postHandle(requestWrapper, responseWrapper);
        } catch (Exception e) {
            exception = e;
        } finally {
            afterCompletion(requestWrapper, responseWrapper, exception);
        }
    }

    public boolean preHandle(RequestWrapper requestWrapper, ResponseWrapper responseWrapper)throws Exception {
        return true;
    }

    public void postHandle(RequestWrapper requestWrapper, ResponseWrapper responseWrapper) throws Exception{
    }

    public void afterCompletion(RequestWrapper requestWrapper, ResponseWrapper responseWrapper,
            Exception exception)throws Exception {
    }
}
