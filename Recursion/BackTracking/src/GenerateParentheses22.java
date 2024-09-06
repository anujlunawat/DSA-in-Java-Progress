import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
    public static void main(String[] args) {
        int n = 3;
        List<String> ans = new ArrayList<>();
        generatePar(n, n, ans, "");
        System.out.println(ans);
    }

    static void generatePar(int o, int c, List<String> ans, String s){
        if(o==0 && c==0){

            ans.add(s);
            return;
        }

        if(o > 0 && c > 0){
            generatePar(o-1, c, ans, s + "(");
        }

        if(c > 0 && c > o && !s.isEmpty()){
            generatePar(o, c - 1, ans, s + ")");
        }
    }
}
