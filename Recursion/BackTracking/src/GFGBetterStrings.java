//https://www.geeksforgeeks.org/problems/better-string/1

import java.util.ArrayList;
import java.util.List;

public class GFGBetterStrings {
    public static void main(String[] args) {
        String str1 = "gfg";
        String str2 = "ggg";
        List<String> s = new ArrayList<>();

        betterStr(str1, "", s);
        int count1 = s.size();
        s.clear();

        betterStr(str2, "", s);
        int count2 = s.size();
        System.out.println(count1 + " " + count2);


    }

    static void betterStr(String up, String p, List<String> s){
        if(up.isEmpty()){
            if(!s.contains(p))
                s.add(p);
            return;
        }

        String t = up.substring(1);
        betterStr(t, p + up.charAt(0), s);
        betterStr(t, p, s);
    }
}
