package com.Anuj.Inheritance;

public class SuperClass {
    int width;
    int height;
    int depth;
    int h = -1;

    SuperClass(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    SuperClass(){
        this.width = -1;
        this.height = -1;
        this.depth = -1;
    }

    SuperClass(int side) {
        this.width = side;
        this.height = side;
        this.depth = side;
    }
    double volume(){
        return this.depth * this.height * this.width;
    }

}
