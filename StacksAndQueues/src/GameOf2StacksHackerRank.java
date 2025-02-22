//very slow and not optimized
//maybe it needs dp
// don't know as of now
//will come back to it later

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOf2StacksHackerRank {
    public static void main(String[] args) {
       // ArrayList 'a'
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(15, 5, 18, 19, 19, 2, 4, 17, 7, 16, 14, 5, 19, 2, 5, 7, 5, 12, 15, 1, 7, 8, 2, 12, 12, 4, 19, 18, 1, 11, 2, 16, 16, 0, 7, 7, 15));

        // ArrayList 'b'
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3, 5, 14, 19, 19, 19, 18, 1, 16, 17, 6, 0, 13, 19, 7, 1, 1, 12, 5, 6, 11, 3, 19, 14, 5, 7, 3, 18, 14, 10, 13, 10, 15, 19, 9, 14, 11, 0, 7, 7, 17, 6, 8, 10, 5, 7, 3, 7, 19, 8));

        int maxSum = 64;

        System.out.println(twoStacks(maxSum, a, b));
    }

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
    // Write your code here
        return twoStacks(maxSum, a, b, 0, 0, 0);
    }
    private static int twoStacks(int maxSum, List<Integer> a, List<Integer> b, int sum, int ptr1, int ptr2){
        if(sum > maxSum){
            return -1;
        }

//        if(ptr1 >= a.size() && ptr2 >= b.size())
//            return 0;


//        if(ptr1 < a.size()){
//            if(ptr2 < b.size()){
//                if(a.get(ptr1) < b.get(ptr2)){
//                    return 1 + twoStacks(maxSum, a, b, sum + a.get(ptr1), ptr1+1, ptr2);
//                }
//                else{
//                    return 1 + twoStacks(maxSum, a, b, sum + b.get(ptr2), ptr1, ptr2 + 1);
//                }
//            }
//            else
//                return 1 + twoStacks(maxSum, a, b, sum + a.get(ptr1), ptr1 + 1, ptr2);
//        }
//
//        return 1 + twoStacks(maxSum, a, b, sum + b.get(ptr2), ptr1, ptr2 + 1);

        int s1 = 0, s2 = 0;
        if(ptr1 < a.size() )
            s1 += 1 + twoStacks(maxSum, a, b, sum + a.get(ptr1), ptr1+1, ptr2);
        if(ptr2 < b.size() ){
            s2 += 1 + twoStacks(maxSum, a, b, sum + b.get(ptr2), ptr1, ptr2 + 1);
        }

        return Math.max(s1, s2);
    }

}
