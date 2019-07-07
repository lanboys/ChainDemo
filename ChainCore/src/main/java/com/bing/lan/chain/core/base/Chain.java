package com.bing.lan.chain.core.base;

/**
 * Created by 蓝兵 on 2019/7/5.
 */

public interface Chain extends Nameable {

    public void doFilter(Request request, Response response) throws Exception;
}