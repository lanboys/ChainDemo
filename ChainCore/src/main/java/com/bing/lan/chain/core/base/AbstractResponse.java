package com.bing.lan.chain.core.base;

/**
 * Created by 蓝兵 on 2019/7/7.
 */

public abstract class AbstractResponse implements Response {

    protected String name;

    public AbstractResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}