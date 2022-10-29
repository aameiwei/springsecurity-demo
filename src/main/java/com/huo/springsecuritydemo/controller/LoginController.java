package com.huo.springsecuritydemo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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


    /**
     * @Secured是专门用于判断是否具有角色的。相当于hasRole能写在方法或类上。参数要以ROLE_开头
     * @PreAuthorize & @PostAuthorize都是方法或者类级别注解
     * @PreAuthorize表示访问方法或类在执行之前先判断权限，大多情况下都是使用这个注解，注解的参数和access()方法参数取值相同，都是权限表达式。
     * @PostAuthorize表示方法或类执行结束后判断权限，此注解很少被使用到。
     * @return
     */
    @RequestMapping("/toMain")
    //@Secured("ROLE_abc")
    //    @PreAuthorize支持以ROLE_开头，配置类不可以
    @PreAuthorize("hasRole('abc')")
    public String toMain() {
        return "redirect:main.html";
    }

    @RequestMapping("/toError")
    public String toError() {
        return "redirect:error.html";
    }

    @RequestMapping("/demo")
    public String demo() {
        return "demo";
    }

}
