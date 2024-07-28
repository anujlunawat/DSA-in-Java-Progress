import java.util.Arrays;

public class ReverseWordsInAString151 {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

//    slower than StringBuilder
     public static String reverseWords(String s) {
        String t = new String("");

        for (String x: s.split(" ")){
            if(x.isEmpty())
                continue;
            t = x + t;
            t = " " + t;
        }
        return t.strip();
    }

//    public static String reverseWords(String s) {
//        StringBuilder t = new StringBuilder();
//
//        for (String x: s.split(" ")){
//            if(x.isEmpty())
//                continue;
//            t.insert(0, x);
//            t.insert(0, " ");
//        }
//        return t.toString().strip();
//    }
}
