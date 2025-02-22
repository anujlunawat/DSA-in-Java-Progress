import java.util.Stack;

public class MyQueue {
//    private int[] arr;
//    private int ptr = 0;

    Stack<Integer> first;
    Stack<Integer> second;

    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }
    
    public void push(int x) {
        first.push(x);
    }
    
//    public int pop() {
//        if(this.empty())
//            return -1;
//
//        int size = first.size();
////        remove all the items from first stack
//        for(int i = 0; i < size; i++){
//            second.push(first.pop());
//        }
//
////        remove the last item
//        int removed_item = second.pop();
//
//        size = second.size();
////        push all the items back in the first stack from the second stack
//        for(int i = 0; i < size; i++){
//            first.push(second.pop());
//        }
//
////        return the popped item
//        return removed_item;
//    }

    public int pop() {
    // Base case: if the first stack is empty, return -1 (stack is empty)
    if (this.empty()) {
        return -1;
    }

    int topmost = first.pop();

    if(first.isEmpty()){
        return topmost;
    }

    int bottommost = pop();

    first.push(topmost);
    return bottommost;
}

    
    public int peek() {
        return first.firstElement();
    }
    
    public boolean empty() {
        return first.isEmpty();
    }
}