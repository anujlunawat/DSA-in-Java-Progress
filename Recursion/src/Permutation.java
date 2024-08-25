import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        String str = "abc";
        List<String> s = new ArrayList<>();
        s = permutations("", str);
//        System.out.println(s);
        permutations2("", str);
//        System.out.println(permutationsCount("", "abc"));
    }

    static List<String> permutations(String p, String up){
        if(up.isEmpty()) {
            return Collections.singletonList(p);
        }

        List<String> s = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String start = p.substring(0, i);
            String end = p.substring(i);
            String e = start + up.charAt(0) + end;

            s.addAll(permutations(e, up.substring(1)));
        }

        return s;
    }

    static void permutations2(String p, String up){
        if(up.isEmpty())
        {
            System.out.println(p);
            return;
        }

        for (int i = 0; i <= p.length(); i++) {
            String start = p.substring(0, i);
            String end = p.substring(i);
            String e = start + up.charAt(0) + end;

            permutations2(e, up.substring(1));
        }
    }

    static int permutationsCount(String p, String up){
        if(up.isEmpty())
        {
            return 1;
        }
        int count = 0;

        for (int i = 0; i <= p.length(); i++) {
            String start = p.substring(0, i);
            String end = p.substring(i);
            String e = start + up.charAt(0) + end;

            count += permutationsCount(e, up.substring(1));
        }
        return count;
    }
}
