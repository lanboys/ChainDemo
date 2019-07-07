package com.bing.lan.chain.web.adapter;

import com.bing.lan.chain.core.base.AbstractRequest;

import javax.servlet.ServletRequest;

/**
 * Created by 蓝兵 on 2019/7/7.
 */

public class RequestWrapper extends AbstractRequest {

    ServletRequest originRequest;

    public RequestWrapper(String name, ServletRequest originRequest) {
        super(name);
        this.originRequest = originRequest;
    }

    public ServletRequest getOriginRequest() {
        return originRequest;
    }
}
