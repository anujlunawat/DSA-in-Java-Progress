//incorrect answer
public class ValidParentheses20 {
    public static void main(String[] args) {
        String s = "()[]{]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        int a, b, c=b=a=0;

        for(int i=0; i < s.length(); i+=1){
            if(a<0 || b<0 || c<0)
                return false;

            switch (s.charAt(i)){
                case '(':
                    a++;
                    break;
                case ')':
                    a--;
                    break;
                case '{':
                    b++;
                    break;
                case '}':
                    b--;
                    break;
                case '[':
                    c++;
                    break;
                case ']':
                    c--;
                    break;
            }

        }
        return a==0 && b==0 && c==0;
    }
}
