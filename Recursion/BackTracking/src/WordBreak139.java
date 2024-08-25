import java.util.ArrayList;
import java.util.List;

public class WordBreak139 {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");

        System.out.println(wordBreak2(s, wordDict));
    }

    static boolean wordBreak2(String s, List<String> wordDict){
        if(s.isEmpty())
            return true;

        for(String word: wordDict){
            if (s.startsWith(word)){
                return wordBreak2(s.substring(word.length()), wordDict);
            }
        }
        return false;
    }
}
