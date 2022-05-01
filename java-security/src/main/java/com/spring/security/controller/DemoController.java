package com.spring.security.controller;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableWebSecurity
public class DemoController extends WebSecurityConfigurerAdapter {


    @GetMapping("/")
    public String showHome(){
        return "home";
    }
}
