package com.bing.lan.chain.web.filter;

import com.bing.lan.chain.web.adapter.RequestWrapper;
import com.bing.lan.chain.web.adapter.ResponseWrapper;
import com.bing.lan.chain.web.adapter.WebFilter;
import com.bing.lan.chain.web.adapter.WebFilterChain;

import java.io.PrintWriter;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 蓝兵 on 2019/7/7.
 */

public class LoginFilter extends WebFilter {

    public void doWebFilter(RequestWrapper requestWrapper, ResponseWrapper responseWrapper,
            WebFilterChain webFilterChain) throws Exception {

        if (isLogin((HttpServletRequest) requestWrapper.getOriginRequest())) {
            webFilterChain.doFilter(requestWrapper, responseWrapper);
        } else {
            ServletResponse originResponse = responseWrapper.getOriginResponse();
            System.out.println("doFilter(): 未登录被拦截");
            PrintWriter writer = originResponse.getWriter();
            writer.print("请先登录");
        }
        System.out.println("doFilter(): after " + getName());
    }

    private boolean isLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return "lan".equals(username) && "bing".equals(password);
    }
}
