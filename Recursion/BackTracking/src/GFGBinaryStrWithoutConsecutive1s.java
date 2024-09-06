// https://www.geeksforgeeks.org/problems/generate-all-binary-strings/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
import java.util.ArrayList;
import java.util.List;

public class GFGBinaryStrWithoutConsecutive1s {
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        int n = 3;
        generateBinaryStr(n, "", ans);
//        System.out.println(ans);

        System.out.println(generateBinaryStrRet(n, ""));
    }

    static void generateBinaryStr(int n, String p, List<String> ans){
        if(p.length() == n){
            ans.add(p);
            return;
        }

        if(p.isEmpty() || p.charAt(p.length()-1) != '1')
            generateBinaryStr(n, p + "1", ans);

        generateBinaryStr(n, p + "0", ans);

    }

    static void generateBinaryStr2(int n, String p, List<String> ans){
        if(p.length() == n){
            ans.add(p);
            return;
        }

        if(p.isEmpty() || p.charAt(p.length()-1) != '1') {
            generateBinaryStr2(n, p + "0", ans);
            generateBinaryStr2(n, p + "1", ans);
        }

        else{
            generateBinaryStr2(n, p + "0", ans);
        }
    }

    static List<String> generateBinaryStrRet(int n, String p){
        List<String> ans = new ArrayList<>();
        if(p.length() == n){
            ans.add(p);
            return ans;
        }

        if(p.isEmpty() || p.charAt(p.length()-1) != '1') {
            ans.addAll(generateBinaryStrRet(n, p + "0"));
            ans.addAll(generateBinaryStrRet(n, p + "1"));
        }

        else{
            ans.addAll(generateBinaryStrRet(n, p + "0"));
        }
        return ans;
    }
}
