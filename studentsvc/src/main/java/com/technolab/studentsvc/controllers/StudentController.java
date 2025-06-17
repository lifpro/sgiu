package com.technolab.studentsvc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {
    @GetMapping("hello")
    public String SeyHello(){
        return  "Je suis un controlleur qui expose des ressource sur le etudiatnts";
    }
}
