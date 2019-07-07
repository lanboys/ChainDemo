package com.bing.lan.chain.web.adapter;

import com.bing.lan.chain.core.base.AbstractResponse;

import javax.servlet.ServletResponse;

/**
 * Created by 蓝兵 on 2019/7/7.
 */

public class ResponseWrapper extends AbstractResponse {

    ServletResponse originResponse;

    public ResponseWrapper(String name, ServletResponse originRequest) {
        super(name);
        this.originResponse = originRequest;
    }

    public ServletResponse getOriginResponse() {
        return originResponse;
    }
}
