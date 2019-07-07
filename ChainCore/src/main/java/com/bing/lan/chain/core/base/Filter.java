package com.bing.lan.chain.core.base;

import com.bing.lan.chain.core.config.Config;

/**
 * Created by 蓝兵 on 2019/7/5.
 */

public interface Filter extends Nameable, Orderable {

    public void init(Config filterConfig);

    public void doFilter(Request request, Response response, FilterChain chain) throws Exception;
}
