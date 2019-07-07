package com.bing.lan.chain.core.config;

import com.bing.lan.chain.core.base.Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * Created by 蓝兵 on 2019/7/5.
 */

public class FilterManager {

    private List<Filter> filters = null;
    private List<Config> configs = null;

    private static volatile FilterManager instance = null;
    public static String FILTER_CONFIG_FILE = "filter.properties";

    private FilterManager() {
        init();
    }

    public static FilterManager getInstance() {
        if (instance == null) {
            synchronized (FilterManager.class) {
                if (instance == null) {
                    instance = new FilterManager();
                }
            }
        }
        return instance;
    }

    private void init() {
        // 从属性文件中获取配置的filter
        parseProperties();

        // 初始化filter
        initFilter();
    }

    private void parseProperties() {

        Properties properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(FILTER_CONFIG_FILE));
            Enumeration<?> enumeration = properties.propertyNames();
            configs = new ArrayList<Config>();
            while (enumeration.hasMoreElements()) {
                String key = (String) enumeration.nextElement();
                if (key.startsWith("filter")) {
                    //System.out.println("parseProperties(): " + key);
                    String className = properties.getProperty(key);
                    Config config = new Config(key, className);

                    configs.add(config);
                    if (key.equals("filter-login")) {
                        config.setOrder(20);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (configs == null || configs.isEmpty()) {
            throw new RuntimeException("at least one config");
        }

        // 排序
        Collections.sort(configs, new Comparator<Config>() {
            public int compare(Config o1, Config o2) {
                return o2.getOrder() - o1.getOrder();
            }
        });
    }

    private void initFilter() {
        filters = new ArrayList<Filter>();
        for (Config config : configs) {
            try {
                Class<?> aClass = Class.forName(config.getFilterClassName());
                Filter filter = (Filter) aClass.newInstance();
                filter.init(config);

                filters.add(filter);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }
}
