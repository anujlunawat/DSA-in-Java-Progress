import java.util.ArrayList;
import java.util.List;

public class WordBreak139 {
    public static void main(String[] args) {
         String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = new ArrayList<>(List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
//        System.out.println(wordBreak(s, wordDict, s.length()));
        System.out.println(wordBreak(s, wordDict, 1));
    }

    public static boolean wordBreak(String s, List<String> wordDict, int len) {
        boolean ans = false;
        if(s.isEmpty())
            return true;

        if(len > s.length())
            return ans;

        String subStr = s.substring(0, len);
        if(wordDict.contains(subStr)){
            ans = wordBreak(s.substring(len), wordDict, 1);
            if(ans)
                return ans;
        }

        if(len < s.length())
            ans = wordBreak(s, wordDict, len + 1);

        return ans;
    }
}
