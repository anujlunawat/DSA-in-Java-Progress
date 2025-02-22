import java.util.Stack;

public class MinInsertionsToBalance1541 {
    public static void main(String[] args) {
        String s = "(()))(()))()())))";
        System.out.println(minInsertions(s));
    }

    public static int minInsertions(String s) {
        return minInsertions(s, new Stack<Character>());
    }

    private static int minInsertions(String s, Stack<Character> stack){

        if(s.isEmpty()) {
            int count = 0;
            while(!stack.isEmpty()){
                int top = stack.pop();
                if (top == ')') {
                    if(!stack.isEmpty()) {
                        stack.pop();
                        count++;
                    }
                    else{
                        count+=2;
                    }

                }
                else
                    count+=2;
            }
            return count;
        }

        char first = s.charAt(0);

        if(first == '('){
            stack.push(first);
        }

        else{
            if(stack.isEmpty() || stack.size() < 2){
                stack.push(first);
                return minInsertions(s.substring(1), stack);
            }

            char b1 = stack.pop();
//            char b2 = stack.pop();
            if(b1 == ')' && stack.peek() == '('){
                stack.pop();
            }
            else{
                stack.push(b1);
                stack.push(first);
            }
        }
        return minInsertions(s.substring(1), stack);
    }
}
