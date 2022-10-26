package com.huo.springsecuritydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author 小源同学
 * @Date 2022 01 14 16 24
 * @Describe UserDetailsService 的实现类
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("执行了loadUserByUsername方法");
        //1.查询数据库，用户名称/账号是否存在，如果不存在就抛出UsernameNotFoundException异常
//        if (!"admin".equals(username)){
//            throw new UsernameNotFoundException("用户名不存在");
//        }
        //2.把查询的密码（注册时加密过）进行解析，或者直接把密码放入构造方法
        String password = passwordEncoder.encode("123");
        return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal,huo"));
    }
}
