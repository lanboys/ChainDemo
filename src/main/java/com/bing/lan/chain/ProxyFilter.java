package com.bing.lan.chain;

import com.bing.lan.chain.base.FilterChain;
import com.bing.lan.chain.base.Request;
import com.bing.lan.chain.base.Response;

/**
 * Created by 蓝兵 on 2019/7/5.
 */

public class ProxyFilter extends AbstractFilter {

    public void doFilter(Request request, Response response, FilterChain chain) {

        System.out.println("doFilter(): before " + getName());

        chain.doFilter(request, response);

        System.out.println("doFilter(): after " + getName());
    }
}
