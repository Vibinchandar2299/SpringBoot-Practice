package com.example.FirstProject;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;

@Component //Creates object
@Primary // When more than one class is annotated with @Component, use Primary to consider this first.

public class Pen implements Writer{
    public void write(){
        System.out.println("Using Pen...!");
    }

}