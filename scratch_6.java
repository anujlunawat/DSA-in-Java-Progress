import java.util.ArrayList;
import java.util.List;

class Example{
    int a=12;
    int b=24;

    Example(){
        this(100);
        System.out.println("Inside the empty constructor");
    }
    Example(int a){
        this.a = a;
    }
}
class Scratch {
    public static void main(String[] args) {
        Example e1 = new Example();
        System.out.println(e1.a);
    }
}