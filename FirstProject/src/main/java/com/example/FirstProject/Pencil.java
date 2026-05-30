package com.example.FirstProject;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;

@Component
@Primary
public class Pencil implements Writer{
    public void write(){
        System.out.println("Using Pencil...!");
    }
}