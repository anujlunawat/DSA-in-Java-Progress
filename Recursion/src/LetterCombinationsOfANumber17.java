import java.util.ArrayList;
import java.util.List;

class LetterCombinationsOfANumber17 {
    public static void main(String[] args) {
        String t = "79";
        System.out.println(letterCombinations("", t));
    }

   static ArrayList<String> letterCombinations(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }

        ArrayList<String> ans = new ArrayList<>();

        int letter = up.charAt(0) - '0';
        int start = (letter - 2) * 3 + (letter > 7 ? 1 : 0);
        int end = (start + 3) + (letter==7 || letter==9 ? 1 : 0);

        for(int i = start; i < end; i++){
            char t = (char)('a' + i);
            ans.addAll(letterCombinations(p+t, up.substring(1)));
        }
        return ans;
   }
}