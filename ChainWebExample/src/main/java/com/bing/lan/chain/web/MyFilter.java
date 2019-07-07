package com.bing.lan.chain.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Created by 蓝兵 on 2019/7/4.
 */

@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init(): ");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter(): 1");

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("doFilter(): 2");
    }

    @Override
    public void destroy() {
        System.out.println("destroy(): ");
    }
}
