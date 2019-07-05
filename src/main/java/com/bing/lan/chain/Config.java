package com.bing.lan.chain;

import com.bing.lan.chain.base.Orderable;

/**
 * Created by 蓝兵 on 2019/7/5.
 */

public class Config implements Orderable {

    private String filterClassName;
    private String name;
    private int order;

    public Config(String name, String filterClassName) {
        this.name = name;
        this.filterClassName = filterClassName;
    }

    public String getFilterClassName() {
        return filterClassName;
    }

    public void setFilterClassName(String filterClassName) {
        this.filterClassName = filterClassName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
