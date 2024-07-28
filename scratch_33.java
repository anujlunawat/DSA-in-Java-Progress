import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        String s = "this is a string";
        StringBuilder builder = new StringBuilder("this is a stringbuilder");
        System.out.println(builder);
        System.out.println(Arrays.toString(builder.toString().toCharArray()));



//        String str = "";
//        System.out.println(palindrome(new StringBuilder(str)));
//        System.out.println(palindromeAlt(str));
    }

    static boolean palindrome(String str){
        String s = "";
        for (int i = str.length()-1; i >= 0; i--) {
            s += str.charAt(i);
        }

        return s.equals(str);
    }

    static boolean palindrome(StringBuilder str){
        String s = str.toString();
        str.reverse();
        return str.toString().equals(s);
    }

    static boolean palindromeAlt(String str){
        for (int i = 0; i < str.length() / 2 ; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
        }
        return true;
    }
}