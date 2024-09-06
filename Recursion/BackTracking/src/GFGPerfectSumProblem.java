//  https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
//  Similar t CombinationSum39
//didnt work
//work on this the next time you come across
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GFGPerfectSumProblem {
    public static void main(String[] args) {
        int[] candidates = {1, 0};
        int target = 1;
        System.out.println(combinations(candidates, target, new ArrayList<>(), 0, 0));
    }

    static int combinations(int[] candidates, int target, List<Integer> p, int sum, int start){
        if(sum == target){
            System.out.println(p);
            return 1;
        }

        int count = 0;
        if(sum > target)
            return 0;

        for(int i = start; i < candidates.length; i++){
            if(sum + candidates[i] <= target){
                p.add(candidates[i]);
                count += combinations(candidates, target, p, sum+candidates[i], i+1);
                p.removeLast();
            }
        }
        return count % ((int) Math.pow(10, 9) + 7);
    }
}
