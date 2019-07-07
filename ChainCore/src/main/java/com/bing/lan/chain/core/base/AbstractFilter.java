package com.bing.lan.chain.core.base;

import com.bing.lan.chain.core.config.Config;

/**
 * Created by 蓝兵 on 2019/7/5.
 */

public abstract class AbstractFilter implements Filter {

    private Config config;

    public void init(Config config) {
        this.config = config;
    }

    public String getName() {
        return config.getName();
    }

    public int getOrder() {
        return config.getOrder();
    }
}
