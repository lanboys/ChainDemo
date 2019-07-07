package com.bing.lan.chain.web.filter;

import com.bing.lan.chain.web.adapter.RequestWrapper;
import com.bing.lan.chain.web.adapter.ResponseWrapper;

/**
 * Created by 蓝兵 on 2019/7/7.
 */

public class AnonymousFilter extends AccessControlFilter {

    protected boolean isAccessAllowed(RequestWrapper request, ResponseWrapper response,
            String path) throws Exception {
        return true;
    }

    protected boolean onAccessDenied(RequestWrapper request, ResponseWrapper response,
            String path) throws Exception {
        return false;
    }
}
