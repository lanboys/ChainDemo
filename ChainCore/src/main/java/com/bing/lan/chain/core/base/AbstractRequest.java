package com.bing.lan.chain.core.base;

/**
 * Created by 蓝兵 on 2019/7/7.
 */

public abstract class AbstractRequest implements Request {

    protected String name;

    public AbstractRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}