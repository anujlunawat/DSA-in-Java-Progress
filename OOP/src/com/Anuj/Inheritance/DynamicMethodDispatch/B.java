package com.Anuj.Inheritance.DynamicMethodDispatch;

public class B extends A {
    int i = 20;

    static void greeting(){
        System.out.println("Hello, I am in B");
    }

    void callme(){
        System.out.println("Inside B");
    }
}
