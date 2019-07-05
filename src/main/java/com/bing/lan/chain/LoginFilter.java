package com.bing.lan.chain;

import com.bing.lan.chain.base.FilterChain;
import com.bing.lan.chain.base.Request;
import com.bing.lan.chain.base.Response;

/**
 * Created by 蓝兵 on 2019/7/5.
 */

public class LoginFilter extends AbstractFilter {

    public void doFilter(Request request, Response response, FilterChain chain) {

        System.out.println("doFilter(): before " + getName());

        if (System.currentTimeMillis() % 2 == 0) {
            chain.doFilter(request, response);
        } else {
            System.out.println("doFilter(): 被拦截");
        }

        System.out.println("doFilter(): after " + getName());
    }
}
