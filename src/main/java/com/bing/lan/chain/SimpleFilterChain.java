package com.bing.lan.chain;

import com.bing.lan.chain.base.Filter;
import com.bing.lan.chain.base.FilterChain;
import com.bing.lan.chain.base.Request;
import com.bing.lan.chain.base.Response;

import java.util.List;

/**
 * Created by 蓝兵 on 2019/7/5.
 */

public class SimpleFilterChain implements FilterChain {

    private List<Filter> filters;
    private int index = 0;
    private String name;

    public SimpleFilterChain(String name) {
        this.name = name;
        filters = FilterManager.getInstance().getFilters();
        if (filters == null || filters.isEmpty()) {
            throw new RuntimeException("no filter to execute this chain");
        }
    }

    public void doFilter(Request request, Response response) {
        //index < filters.size()
        int size = filters.size();
        if (index < size) {
            index++;
            filters.get(index - 1).doFilter(request, response, this);
        } else {
            System.out.println("doFilter(): filter chain finish");
        }
    }

    public String getName() {
        return name;
    }
}
