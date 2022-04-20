package com.mvc.impl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping(value = "/form")
public class HelloController {

    @RequestMapping(value = "/showForm")
    public String showForm() {
        return "helloWorld-form";
    }

    @RequestMapping(value = "/processForm")
    public String processForm() {
        return "hello_world";
    }

    //read form data and add data to the model
    @RequestMapping("/processFormV2")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        //read request paramater from html
        String name = request.getParameter("studentName");
        //convert data to all caps
        name = name.toUpperCase();
        //create message
        String result = "YO!!  " + name;
        //add message to model
        model.addAttribute("message", result);
        return "hello_world";
    }

    @RequestMapping("/processFormV3")
    public String processFormV3(@RequestParam("studentName") String name, Model model) {
        //convert data to all caps
        name = name.toUpperCase();
        //create message
        String result = "YO!!  " + name+" from request param";
        //add message to model
        model.addAttribute("message", result);
        return "hello_world";
    }

}