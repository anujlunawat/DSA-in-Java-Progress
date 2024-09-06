package com.Anuj.Inheritance;

public class BoxPrice extends SubClass {
    double price;

    public BoxPrice(){
        this.price = -1;
    }

    public BoxPrice(double price) {
        this.price = price;
    }

    public BoxPrice(int width, int height, int depth, String colour, double price) {
        super(width, height, depth, colour);
        this.price = price;
    }

    public BoxPrice(String colour, double price) {
        super(colour);
        this.price = price;
    }

    void details(){
        System.out.println(super.height);
        System.out.println(super.width);
        System.out.println(super.depth);
        System.out.println(super.h);
    }
}
