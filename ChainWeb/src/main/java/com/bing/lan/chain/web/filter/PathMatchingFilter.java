package com.bing.lan.chain.web.filter;

import com.bing.lan.chain.web.adapter.RequestWrapper;
import com.bing.lan.chain.web.adapter.ResponseWrapper;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletRequest;

/**
 * Created by 蓝兵 on 2019/7/7.
 */

public class PathMatchingFilter extends AdviceFilter {

    protected List<String> appliedPaths = new LinkedList<String>();

    {
        appliedPaths.add("xxx");
    }

    public final boolean preHandle(RequestWrapper requestWrapper, ResponseWrapper responseWrapper) throws Exception {
        if (this.appliedPaths == null || this.appliedPaths.isEmpty()) {
            return true;
        }
        for (String path : this.appliedPaths) {
            if (pathsMatch(path, requestWrapper.getOriginRequest())) {
                return onPreHandle(requestWrapper, responseWrapper, path);
            }
        }
        return true;
    }

    public boolean onPreHandle(RequestWrapper requestWrapper, ResponseWrapper responseWrapper, String path) throws Exception {
        return true;
    }

    protected boolean pathsMatch(String path, ServletRequest request) {
        return true;
    }
}
