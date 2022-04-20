package com.mvc.impl.controller;

import com.mvc.impl.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("/showForm")
    public String showForm(Model model){
        //create object
        Student theStudent = new Student();
        //add object to  model
        model.addAttribute("student", theStudent);
        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
        System.out.println(theStudent.getFirstName() + " "+ theStudent.getLastName());
        return "student-confirmation";
    }
}
