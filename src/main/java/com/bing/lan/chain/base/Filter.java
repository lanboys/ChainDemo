package com.bing.lan.chain.base;

import com.bing.lan.chain.Config;

/**
 * Created by 蓝兵 on 2019/7/5.
 */

public interface Filter extends Nameable, Orderable {

    public void init(Config filterConfig);

    public void doFilter(Request request, Response response, FilterChain chain);
}
