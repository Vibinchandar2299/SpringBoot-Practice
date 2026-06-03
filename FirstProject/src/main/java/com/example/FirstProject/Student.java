package com.example.FirstProject;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;



@Component
public class Student {

    public int age;

    //Object Injection

    //f Filed injection
//    @Autowired  // Created object is injected here in the filed
//            Pen p;

    // Constructor injection
//    Pen p;   -->reference created
//    @Autowired
//    public Student(Pen p)
//    {
//        this.p = p;  -->object given to the reference
//    }

    // Setter injection
//    Pen p;   -->reference created
//    @Autowired
//    public void setP(Pen p) {
//        this.p = p;  --> gives tge object to the reference
//    }

    @Autowired
    @Qualifier("pen")  // When more than one class is annotated with @Component, use @Primary for first preference, then use @Qualifier

    Writer w;
    public void study(){
        System.out.println("I'm an Engineering Student");
        w.write();
    }

    public Student (){
        System.out.println("Object Created");
    }



}