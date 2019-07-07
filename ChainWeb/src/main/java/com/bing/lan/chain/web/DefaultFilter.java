package com.bing.lan.chain.web;

import com.bing.lan.chain.web.adapter.RequestWrapper;
import com.bing.lan.chain.web.adapter.ResponseWrapper;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 蓝兵 on 2019/7/5.
 */
@WebFilter(urlPatterns = "/*", initParams = {@WebInitParam(name = "characterEncoding", value = "UTF-8")})
public class DefaultFilter implements Filter {

    FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding(filterConfig.getInitParameter("characterEncoding"));
        response.setCharacterEncoding(filterConfig.getInitParameter("characterEncoding"));
        response.setContentType("text/html");

        DefaultChain defaultChain = new DefaultChain("web-filter-chain", chain);

        defaultChain.doFilter(new RequestWrapper("request", request),
                new ResponseWrapper("response", response));
    }

    public void destroy() {

    }
}
