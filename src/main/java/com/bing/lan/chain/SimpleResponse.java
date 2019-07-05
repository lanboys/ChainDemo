package com.bing.lan.chain;

import com.bing.lan.chain.base.Response;

/**
 * Created by 蓝兵 on 2019/7/5.
 */

public class SimpleResponse implements Response {

    private String name;

    public SimpleResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
