package com.Anuj.Inheritance;

public class SubClass extends SuperClass{
    String colour;
    int h = -2;

    SubClass(){
        colour = "Black";
    }

    public SubClass(int width, int height, int depth, String colour) {
        super(width, height, depth);
        this.colour = colour;
    }

    public SubClass(String colour) {
        this.colour = colour;
    }

    public SubClass(int side, String colour) {
        super(side);
        this.colour = colour;
    }

    void boxDetails(){
        System.out.println("Colour of this box is " + this.colour);
        System.out.println("Dimensions of the box:" + "\n" + "height: " + height + "\nwidth: " + width + "\ndepth:" + depth);
    }
}
