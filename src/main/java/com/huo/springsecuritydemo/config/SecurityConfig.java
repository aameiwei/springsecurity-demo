package com.huo.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Author 小源同学
 * @Date 2022 01 14 16 17
 * @Describe  Security 的配置类
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //自定义登录页面
        http.formLogin()
                //当发现、login的时候认为是登录，去执行 UserDetailsServiceImpl->loadUserByUsername,必须和表单提交的接口一样，回去执行自定义的登录逻辑
                .loginProcessingUrl("/login")
                //自定义登录页面
                .loginPage("/login.html")
                //登陆成功要跳转的页面，必须是post请求
                .successForwardUrl("/toMain")
        ;

        //设置了自定义登陆页面之后，security提供的原始的认证将全部失效
        //授权认证
        http.authorizeRequests()
                //放行登录页面，登陆失败页面都不需要认证
                .antMatchers("/login.html").permitAll()
                //所以要对所有的请求做拦截做认证【必须是登录之后才能被访问】
                .anyRequest().authenticated()
        ;

        //暂时理解为防火墙
        //关闭csrf防护
        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder getPassWord() {
        return new BCryptPasswordEncoder();
    }
}
