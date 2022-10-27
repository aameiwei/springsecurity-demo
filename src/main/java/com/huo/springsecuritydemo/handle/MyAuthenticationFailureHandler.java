package com.huo.springsecuritydemo.handle;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 小源同学
 * @Date 2022 01 14 18 42
 * @Describe 自定义登陆失败处理器
 **/
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private String failure_url;

    public MyAuthenticationFailureHandler(String failure_url) {
        this.failure_url = failure_url;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.sendRedirect(failure_url); 
    }
}

