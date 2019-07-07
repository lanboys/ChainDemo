package com.bing.lan.chain.core.simple;

import com.bing.lan.chain.core.base.AbstractFilter;
import com.bing.lan.chain.core.base.FilterChain;
import com.bing.lan.chain.core.base.Request;
import com.bing.lan.chain.core.base.Response;

/**
 * Created by 蓝兵 on 2019/7/5.
 */

public class Simple1Filter extends AbstractFilter {

    public void doFilter(Request request, Response response, FilterChain chain) throws Exception {

        System.out.println("doFilter(): before " + getName());

        if (System.currentTimeMillis() % 2 == 0) {
            chain.doFilter(request, response);
        } else {
            System.out.println("doFilter(): 被拦截");
        }

        System.out.println("doFilter(): after " + getName());
    }
}
