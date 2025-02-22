import java.util.ArrayList;
import java.util.List;

public class BetterStringGFG {
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        betterString("ggg", "", ans, 0);
        System.out.println(ans);
    }

    public static void betterString(String str1, String p, List<String> ans, int ind){
        if(ind >= str1.length()){
            if(!ans.contains(p))
                ans.add(p);
            return;
        }

//        take the char at index ind
        betterString(str1, p + str1.charAt(ind), ans, ind + 1);
//        not taking the char at index ind
        betterString(str1, p, ans, ind + 1);
    }
}
