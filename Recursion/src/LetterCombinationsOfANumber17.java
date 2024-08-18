import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfANumber17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        return combinations(digits, "", "abc");
    }

    public static List<String> combinations(String digits, String p, String up){
        if(up.isEmpty())
            return Collections.singletonList(p);

        List<String> t = new ArrayList<>();

        for(char num: digits.toCharArray()){
            int s = 97 + (num-2)*3;
            int limit = (num == '9' ? 4 : 3);

            for (int i = s; i < s+limit; i++) {
                p = p + (char)i;
                t.addAll(combinations("", p, up.substring(1)));
            }
        }
        return t;
    }
}
