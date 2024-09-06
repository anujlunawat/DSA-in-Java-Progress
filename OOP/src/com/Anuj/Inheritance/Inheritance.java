package com.Anuj.Inheritance;

public class Inheritance {
    public static void main(String[] args) {
        SuperClass sup = new SuperClass(10, 20, 30);
//        System.out.println(sup.volume());
//
        SubClass sub = new SubClass(10, "White");
//        System.out.println(sub.volume());
//
//        System.out.println(sub.height);
//        System.out.println(sub.width);

        SuperClass sup2 = sub;
//        sub.boxDetails();
        System.out.println(sup2.height);
        System.out.println();

        BoxPrice bp = new BoxPrice(10, 20, 30, "Black", 10);
        bp.details();
        bp.boxDetails();

//        System.out.println(bp.width);
//        System.out.println(bp.height);

    }
}
