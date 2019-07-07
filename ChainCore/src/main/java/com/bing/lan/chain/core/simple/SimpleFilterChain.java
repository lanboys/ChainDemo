package com.bing.lan.chain.core.simple;

import com.bing.lan.chain.core.base.AbstractChain;
import com.bing.lan.chain.core.base.Request;
import com.bing.lan.chain.core.base.Response;

/**
 * Created by 蓝兵 on 2019/7/5.
 */

public class SimpleFilterChain extends AbstractChain {

    private int index = 0;

    public SimpleFilterChain(String name) {
        super(name);
    }

    public void doFilter(Request request, Response response) throws Exception {
        if (index < filters.size()) {
            index++;
            filters.get(index - 1).doFilter(request, response, this);
        } else {
            System.out.println("doFilter(): filter chain finish");
        }
    }
}
