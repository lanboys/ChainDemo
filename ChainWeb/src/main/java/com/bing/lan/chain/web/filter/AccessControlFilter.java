package com.bing.lan.chain.web.filter;

import com.bing.lan.chain.web.adapter.RequestWrapper;
import com.bing.lan.chain.web.adapter.ResponseWrapper;

/**
 * Created by 蓝兵 on 2019/7/7.
 */

public abstract class AccessControlFilter extends PathMatchingFilter {

    public boolean onPreHandle(RequestWrapper requestWrapper, ResponseWrapper responseWrapper,
            String path) throws Exception {

        return isAccessAllowed(requestWrapper, responseWrapper, path)
                || onAccessDenied(requestWrapper, responseWrapper, path);
    }

    protected abstract boolean isAccessAllowed(RequestWrapper request,
            ResponseWrapper response, String path) throws Exception;

    protected abstract boolean onAccessDenied(RequestWrapper request,
            ResponseWrapper response, String path) throws Exception;
}
