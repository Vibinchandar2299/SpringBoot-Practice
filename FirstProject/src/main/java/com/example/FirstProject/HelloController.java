package com.example.FirstProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService s;

    @GetMapping("/")
    public String greet() {
        return s.greeting();
    }

    @GetMapping("/about")
    public String aboutus() {
        return s.about();
    }

    @GetMapping("/about/lecture")
    public String Lec() {
        return s.lecture();
    }
}
