package com.example.FirstProject;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String greeting() {
        return "hello springboot";
    }

    public String about() {
        return "springboot cource";
    }

    public String lecture() {
        return "welcome to lecture";
    }
}