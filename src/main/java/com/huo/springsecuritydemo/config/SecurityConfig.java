package com.huo.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Author 小源同学
 * @Date 2022 01 14 16 17
 * @Describe  Security 的配置类
 **/
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder getPassWord() {
        return new BCryptPasswordEncoder();
    }
}
