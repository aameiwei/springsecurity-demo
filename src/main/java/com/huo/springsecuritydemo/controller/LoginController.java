package com.huo.springsecuritydemo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    /**
     * 这里由于在securityConfig中设置了loginProcessingUrl属性，就失效了
     * @return
     */
//    @RequestMapping("/login")
//    public String login(){
//        return "redirect:main.html";
//    }

    //@Secured是专门用于判断是否具有角色的。相当于hasRole能写在方法或类上。参数要以ROLE_开头
    @RequestMapping("/toMain")
    @Secured("ROLE_abc")
    public String toMain() {
        return "redirect:main.html";
    }

    @RequestMapping("/toError")
    public String toError() {
        return "redirect:error.html";
    }

    @GetMapping("/demo")
    public String demo() {
        return "redirect:main.html";
    }

}
