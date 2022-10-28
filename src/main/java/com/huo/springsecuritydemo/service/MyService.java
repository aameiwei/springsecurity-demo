package com.huo.springsecuritydemo.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author 小源同学
 * @Date 2022 01 14 22 12
 * @Describe Please describe the role of this class
 **/
public interface MyService {
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}

