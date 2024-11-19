package com.p1;

class Derived {
    int i = 12;
    private static int p = 100;
    static int t = 200;

    static class innerClass{
        int j = Derived.p;
        int s = t;
        void change_p_val(){
            p = 100;
        }
    }
}
