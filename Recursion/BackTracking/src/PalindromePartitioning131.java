// little difficult to understand

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromePartitioning131 {
    public static void main(String[] args) {
        String s = "cbbbcc";
        List<List<String>> t = new ArrayList<>();

        partition2(s, t, new ArrayList<>());
//        partition2(s);
        System.out.println(t);
    }

    static void partition2(String s, List<List<String>> t, List<String> ls){

        if(s.isEmpty()) {
            t.add(new ArrayList<>(ls));
            return;
        }

        for(int e=0; e < s.length(); e++){
            String substring = s.substring(0, e+1);
            if(checkPalindrome(substring)){
                ls.add(substring);
                partition2(s.substring(e + 1), t, ls);
                ls.removeLast();
            }


        }
    }
    static boolean checkPalindrome(String s){
        int start = 0, end = s.length()-1;

        while(start < end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
