package com.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @RequestMapping("/login_success")
    @ResponseBody
    public String loginSuccess(){
        String session = getUserSession();
        System.out.println(session);
        return session+"login_success";
    }
    @RequestMapping("/logout_success")
    @ResponseBody
    public String logoutSuccess(){
        return "logout_success";
    }

    @RequestMapping("/login.html")
    public String toIndexPage() {
        return "index";
    }
    private String getUserSession(){
        String session = null;
        Authentication  authentication= SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if(principal==null){
            session = "null";
        }else{
            session = principal.toString();
        }
        return session;
    }
}

