package com.huo.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
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

    @RequestMapping("/toMain")
    public String toMain() {
        return "redirect:main.html";
    }
}
