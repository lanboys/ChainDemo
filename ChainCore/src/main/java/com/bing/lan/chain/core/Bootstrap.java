package com.bing.lan.chain.core;

import com.bing.lan.chain.core.simple.SimpleFilterChain;
import com.bing.lan.chain.core.simple.SimpleRequest;
import com.bing.lan.chain.core.simple.SimpleResponse;

/**
 * Created by 蓝兵 on 2019/7/5.
 */

public class Bootstrap {

    public static void main(String[] args) {

        for (int i = 0; i < 1; i++) {
            SimpleFilterChain chain = new SimpleFilterChain("[filterChain-" + i + "]");
            chain.doFilter(new SimpleRequest("[request-" + i + "]"),
                    new SimpleResponse("[response-" + i + "]"));
        }
    }
}
