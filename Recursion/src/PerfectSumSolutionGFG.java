import java.util.ArrayList;
import java.util.List;

public class PerfectSumSolutionGFG {
    public static void main(String[] args) {
        int[] nums = {0, 10, 0};
        perfectSum(nums, 0, 0, 0);
    }

    private static int perfectSum(int[] nums, int target, int curr_sum, int ind){
        int count = 0;
        if(curr_sum == target)
            return 1;
        if(ind >= nums.length || curr_sum > target)
            return 0;


//        here, we take the number
        // p.add(nums[ind]);
        count += perfectSum(nums, target, curr_sum + nums[ind], ind + 1);
        // p.removeLast();
//        here, we do not take the number
        count += perfectSum(nums, target, curr_sum, ind + 1);

        return count;
    }
}
