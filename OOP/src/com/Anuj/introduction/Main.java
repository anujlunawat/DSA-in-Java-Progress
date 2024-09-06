package com.Anuj.introduction;

//new is a special operator tha allocates memory
public class Main {
    public static void main(String[] args) {
        TempClass t = new TempClass();
//        System.out.println(TempClass.a);
//        TempClass.StaticClass.printValue2();
//        TempClass.NonStaticClass.printValue2();
//        TempClass.NonStaticClass non = t.new NonStaticClass();
//        non.printValue();
//        TempClass.StaticClass stat = new TempClass.StaticClass();
//        stat.printValue();

        func(1,2,3,4,5,6,7,8,9,0);

    }

    static void func(int ... v){
        for(var x: v)
            System.out.print(x + " ");;
    }
}

class TempClass{
    static int a = 10;
    int b = 20;

    static class StaticClass{
        int i = a;
        static int j = a+10;
        void printValue(){
            System.out.println("In StaticClass Value of i is: "+ i);
        }

        static void printValue2(){
            System.out.println("In StaticClass Value of j is: "+ j);
        }
    }
    class NonStaticClass{
        int i = a;
        static int j = a+10;
        void printValue(){
            System.out.println("In NonStaticClassValue of i is: "+ i);
        }

        static void printValue2(){
            System.out.println("In NonStaticClassValue Value of j is: "+ j);
        }
    }
}