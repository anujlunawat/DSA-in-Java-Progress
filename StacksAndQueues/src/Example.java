import java.util.Stack;

public class Example {
    public static void main(String[] args) {
        Stack<Integer> temp = new Stack<>();
        temp.push(11);
        temp.push(34);
        temp.push(-12);
        temp.push(90);
        temp.push(1);
        temp.push(0);

        System.out.println(temp.empty());
        System.out.println("Topmost item is: " + temp.peek());
        System.out.println("Removing topmost item: " + temp.pop());
        System.out.println("-12 is at position: " + temp.search(-12));
        System.out.println(temp.contains(1));

    }
}
