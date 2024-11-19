import java.util.ArrayList;
import java.util.List;

public class GFGCircleOfStrings {
    public static void main(String[] args) {
        String[] arr = {"ab", "bc", "cd", "da"};
        System.out.println(isCircle(arr));
    }
    public static int isCircle(String[] arr) {
        List<String> sb = new ArrayList<>();
        return returnChar(arr," ", 0, sb, " ");
    }

    private static int returnChar(String[] arr, String s, int ind, List sb, String first){
        if(sb.size() == arr.length) {
            return 1;
        }
        if(ind >= arr.length)
            return 0;
        if(sb.contains(arr[ind])){
            returnChar(arr, s, ind+1, sb, first);
        }

        if(s == " "){
            for(int i = 0; i < arr.length; i++) {
                sb.add(arr[i]);
                first = arr[i];
                returnChar(arr, arr[i], 0, sb, first);
                sb.removeLast();
            }
        }
        if(s.charAt(s.length() - 1) == arr[ind].charAt(0)){
            sb.add(arr[ind]);
            returnChar(arr, arr[ind], ind+1, sb, first);
            sb.removeLast();
        }

        return returnChar(arr, s, ind+1, sb, first);
    }
}
