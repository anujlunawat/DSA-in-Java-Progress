import java.util.Stack;

public class ValidParantheses20 {
    public static void main(String[] args) {
        System.out.println(isValid("(])"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        return isValid(s, stack);
    }

    private static boolean isValid(String s, Stack<Character> stack){
        if(s.isEmpty()){
            return stack.isEmpty();
        }

        char c = s.charAt(0);

        if(c == '(' || c == '{' || c == '['){
            stack.push(c);
        }
        else{
            if(c == ')'){
                if(stack.isEmpty() || stack.pop() != '(')
                    return false;
            }
            else if(c == ']'){
                if(stack.isEmpty() || stack.pop() != '[')
                    return false;
            }
            else if(c == '}'){
                if(stack.isEmpty() || stack.pop() != '{')
                    return false;
            }
        }
        return isValid(s.substring(1), stack);

    }

    private static boolean isValid2(String s, Stack<Character> stack){
        if(s.isEmpty())
            return stack.isEmpty();

        char c = s.charAt(0);
        if(c == '(')
            stack.push(')');
        else if(c == '{')
            stack.push('}');
        else if(c == '[')
            stack.push(']');
        else if(stack.isEmpty() || stack.pop() != c)
            return false;
        return isValid2(s.substring(1), stack);
    }


}
