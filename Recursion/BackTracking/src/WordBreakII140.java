import java.util.ArrayList;
import java.util.List;

public class WordBreakII140 {
    public static void main(String[] args) {
        String s = "a";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
//        wordDict.add("pen");
//        wordDict.add("applepen");
//        wordDict.add("pine");
//        wordDict.add("pineapple");
        List<String> ansList = new ArrayList<>();
        printWords(s, wordDict, 1, ansList, "");
        System.out.println(ansList);

    }

    private static void printWords(String s, List<String> wordDict, int len, List<String> ansList, String ansStr){
        if(s.isEmpty()){
//            System.out.println(ansStr);
            ansList.add(ansStr);
            return;
        }

        if(len > s.length()){
//            System.out.println("No such word exists");
            return;
        }

        String subStr = s.substring(0, len);
        if(wordDict.contains(subStr)){
            if (!ansStr.endsWith(" ") && !ansStr.isEmpty())
                ansStr += " ";
            printWords(s.substring(len), wordDict, 1, ansList, ansStr + subStr);
        }

        printWords(s, wordDict, len + 1, ansList, ansStr);
    }
}
