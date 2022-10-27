package com.huo.springsecuritydemo.handle;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 小源同学
 * @Date 2022 01 14 18 34
 * @Describe 自定义登陆成功处理器
 **/
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    /*重定向的连接*/
    private String success_url;

    public MyAuthenticationSuccessHandler(String success_url) {
        this.success_url = success_url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemoteAddr());
        User principal = (User) authentication.getPrincipal();
        System.out.println(principal.getUsername());
        System.out.println(principal.getPassword());//因为安全的原因输出null
        System.out.println(principal.getAuthorities());//权限
        response.sendRedirect(success_url);
    }
}

