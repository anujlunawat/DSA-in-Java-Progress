// https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1

import java.util.Arrays;

public class CountSubsetsWithSumKGFG {
    public static int perfectSum(int[] nums, int target) {
//        return helper(nums.length-1, target, nums);
        arr = new Integer[nums.length][target+1];
//        return helper2(nums.length-1, target, nums);
//        return helper3(nums, target);
//        return helper4(nums, target);
        return helper5(nums, target);
    }

//    recursion
    private static int helper(int i, int target, int[] nums){
        if(i < 0){
            if(target == 0)
                return 1;
            return 0;
        }

        int skip = helper(i-1, target, nums);
        int take = 0;
        if(nums[i] <= target)
            take = helper(i-1, target-nums[i], nums);

        return skip + take;
    }

//    memoization
    static Integer[][] arr;
    private static int helper2(int i, int target, int[] nums){
        if(i < 0){
            if(target == 0)
                return 1;
            return 0;
        }
        if(arr[i][target] != null)
            return arr[i][target];

        int skip = helper2(i-1, target, nums);
        int take = 0;
        if(nums[i] <= target)
            take = helper2(i-1, target-nums[i], nums);

        return arr[i][target] = skip + take;
    }

//    tabulation
    private static int helper3(int[] nums, int target){
        for (Integer[] integers : arr) Arrays.fill(integers, 0);

        arr[0][0] = 1;
        if(nums[0] <= target)
            arr[0][nums[0]] += 1;

        for(int i = 1; i < arr.length; i++){
            for(int t = 0; t <= target; t++){
                int skip = arr[i-1][t];
                int take = 0;
                if(nums[i] <= t)
                    take = arr[i-1][t-nums[i]];

                arr[i][t] = skip + take;
            }
        }
        return arr[arr.length-1][target];
    }

//    tabulation space optimization
    private static int helper4(int[] nums, int target){
        int[] prev = new int[target+1];
        Arrays.fill(prev, 0);
        prev[0] = 1;
        if(nums[0] <= target)
            prev[nums[0]] += 1;

        int[] curr = new int[target+1];
        Arrays.fill(curr, 0);

        for(int i = 1; i < arr.length; i++){
            for(int t = 0; t <= target; t++){
                int skip = prev[t];
                int take = 0;
                if(nums[i] <= t)
                    take = prev[t-nums[i]];

                curr[t] = skip + take;
            }
            prev = curr;
            curr = new int[target+1];
            Arrays.fill(curr, 0);
        }
        return prev[target];

    }//    tabulation space optimization++
    private static int helper5(int[] nums, int target){
        int[] prev = new int[target+1];
        Arrays.fill(prev, 0);
        prev[0] = 1;

        if(nums[0] <= target)
            prev[nums[0]] += 1;

        for(int i = 1; i < nums.length; i++){
//            backward iteration (correct)
//              it doesn't mess with the previous results
            for(int t = target; t >= nums[i]; t--){
//                forward iteration (incorrect)
//                This does not work correctly in the space-optimized tabulation approach because:
//                You are iterating from left to right (in increasing order).
//                This causes overwriting issues because the prev[] array is being updated while you are still using it to reference values from the same iteration.
//            for(int t = nums[i]; t <= target; t++){
                prev[t] += prev[t-nums[i]];
            }
        }
        return prev[target];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(perfectSum(nums, 4));
//
//        for(var x: arr)
//            System.out.println(Arrays.toString(x));
    }

//    Question: can all space optimized tabulation be converted to one array solutions
//
//
//    ✅ Yes, all space-optimized tabulation solutions can be converted to a single-array solution, but with one major condition:
//You need to iterate in reverse when updating the array during each step. This prevents overwriting values prematurely, ensuring correctness.
//
//💡 Why Reverse Iteration Matters
//When using one-array space optimization, if you iterate forward, the current iteration will depend on values that are already updated in the same round. This leads to incorrect results due to double counting or premature updates.
//✅ Reverse iteration ensures that each number contributes only once, using the values from the previous state.
}
