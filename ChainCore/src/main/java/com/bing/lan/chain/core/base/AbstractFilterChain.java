package com.bing.lan.chain.core.base;

import com.bing.lan.chain.core.config.FilterManager;

import java.util.List;

/**
 * Created by 蓝兵 on 2019/7/7.
 */

public abstract class AbstractFilterChain implements FilterChain {

    protected List<Filter> filters;
    private String name;

    public AbstractFilterChain(String name) {
        this.name = name;
        filters = FilterManager.getInstance().getFilters();
        if (filters == null || filters.isEmpty()) {
            throw new RuntimeException("no filter to execute this chain");
        }
    }

    public String getName() {
        return name;
    }
}
