package com.bing.lan.chain.web.filter;

import com.bing.lan.chain.web.adapter.RequestWrapper;
import com.bing.lan.chain.web.adapter.ResponseWrapper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 蓝兵 on 2019/7/7.
 */

public class LoginFilter extends AccessControlFilter {

    protected boolean isAccessAllowed(RequestWrapper requestWrapper, ResponseWrapper response, String path) {
        return isLogin((HttpServletRequest) requestWrapper.getOriginRequest());
    }

    protected boolean onAccessDenied(RequestWrapper requestWrapper, ResponseWrapper responseWrapper, String path) throws IOException {
        ServletResponse originResponse = responseWrapper.getOriginResponse();
        System.out.println("doFilter(): 未登录被拦截");
        PrintWriter writer = originResponse.getWriter();
        writer.print("请先登录");
        return false;
    }

    private boolean isLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return "lan".equals(username) && "bing".equals(password);
    }
}
