package com.bing.lan.chain;

import com.bing.lan.chain.base.Request;

/**
 * Created by 蓝兵 on 2019/7/5.
 */

public class SimpleRequest implements Request {

    private String name;

    public SimpleRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
