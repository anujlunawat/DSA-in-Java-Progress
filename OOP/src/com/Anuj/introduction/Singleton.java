package com.Anuj.introduction;

public class Singleton {

    static final int k = 12;

    Singleton(){

    }

    private static Singleton singleton;

    static Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
