package com.Anuj.Inheritance.DynamicMethodDispatch;

public class DMD {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();

        A r;

        r = a;
//        System.out.println(r.i);
        r.callme();
        r = b;
//        System.out.println(r.i);
        r.callme();
        r = c;
//        System.out.println(r.i);
        r.callme();

//        you cannot overload static methods
//        r = a;
//        r.greeting();
//        r = b;
//        r.greeting();
//        r = c;
//        r.greeting();
//
////        but you can, sure, access them this way
////        this is not method overloading anyway
//        A.greeting();
//        B.greeting();
//        C.greeting();
//        a.greeting();
//        b.greeting();
//        c.greeting();
//        c.greet();
    }
}
