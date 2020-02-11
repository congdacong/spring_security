package com.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/add")
    public String add(){
        return "add";
    }
    @RequestMapping("/insert")
    public String insert(){
        return "insert";
    }
    @RequestMapping("/update")
    public String update(){
        return "update";
    }
    @RequestMapping("/delete")
    public String delete(){
        return "delete";
    }
}
