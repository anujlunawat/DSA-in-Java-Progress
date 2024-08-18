import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr = subseq2("", "abc");
        System.out.println(arr);
//        subseq("", "abc", arr);
//        System.out.println(arr);
//        subseq("", "abcd");
    }

    static void subseq(String p, String up){
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        subseq(p + up.charAt(0), up.substring(1));
        subseq(p, up.substring(1));
    }

    static void subseq(String p, String up, ArrayList<String> arr){
        if(up.isEmpty()) {
            arr.add(p);
            return;
        }

        subseq(p + up.charAt(0), up.substring(1), arr);
        subseq(p, up.substring(1), arr);
    }

    static ArrayList<String> subseq2(String p, String up){
        ArrayList<String> arr = new ArrayList<>();
        if(up.isEmpty()) {
            arr.add(p);
            return arr;
        }

        arr.addAll(subseq2(p + up.charAt(0), up.substring(1)));
        arr.addAll(subseq2(p, up.substring(1)));

        return arr;
    }
}
