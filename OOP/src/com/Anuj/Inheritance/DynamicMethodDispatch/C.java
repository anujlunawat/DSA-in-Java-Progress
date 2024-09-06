package com.Anuj.Inheritance.DynamicMethodDispatch;

public class C extends A{
    int i = 30;

    static void greeting(){
        System.out.println("Hello, I am in C");
    }

    void greet(){
        C.greeting();
    }

    void callme(){
        System.out.println("Inside C");
    }
}
