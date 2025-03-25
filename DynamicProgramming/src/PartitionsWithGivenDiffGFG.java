import java.util.Arrays;

public class PartitionsWithGivenDiffGFG {
    static int target, total_sum, diff;
    static int countPartitions(int[] nums, int d) {
        total_sum = 0;
        for(int i = 0; i < nums.length; i++)
            total_sum += nums[i];

        diff = d;

        if ((total_sum - diff) % 2 != 0) {
            return 0;
        }

        target = (total_sum/2) - (d/2);
        arr = new int[nums.length][target+1];

//        for(int i = 0; i < arr.length; i++)
//            Arrays.fill(arr[i], -1);

//        return helper2(nums.length-1, 0, nums);
//        return helper3(nums);
//        return helper4(nums);
        return helper5(nums);
    }

//    recursion
    static int helper(int i,  int t, int[] nums){
        if(i < 0){
            if(t == target)
                return 1;
            return 0;
        }

        int skip = helper(i-1, t, nums);
        int take = 0;
        if(target-t >= nums[i])
            take = helper(i-1, t+ nums[i], nums);

        return take + skip;
    }

//    memoization
    static int[][] arr;
    private static int helper2(int i, int t, int[] nums){
        if(i < 0){
            if(t == target)
                return 1;
            return 0;
        }
        if(arr[i][t] != -1)
            return arr[i][t];

        int skip = helper2(i-1, t, nums);
        int take = 0;
        if(target-t >= nums[i])
            take = helper2(i-1, t+ nums[i], nums);

        return arr[i][t] = take + skip;
    }

//    tabulation
    private static int helper3(int[] nums){
        for (int[] ints : arr) Arrays.fill(ints, 0);

        for(int i = 0; i < nums.length; i++)
            arr[i][0] = 1;
        if(nums[0] <= target)
            arr[0][nums[0]] += 1;

        for(int i = 1; i < nums.length; i++){
            for(int t = 0; t <= target; t++){
                int skip = arr[i-1][t];
                int take = 0;
                if(nums[i] <= t)
                    take = arr[i-1][t-nums[i]];

                arr[i][t] = take + skip;
            }
        }

        return arr[arr.length-1][target];
    }

//    tabulation space optimization
    private static int helper4(int[] nums){
        int[] prev = new int[target+1];
        int[] curr = new int[target+1];

        Arrays.fill(prev, 0);
        prev[0] = 1;
        if(nums[0] <= target)
            prev[nums[0]] += 1;

        for(int i = 1; i < nums.length; i++){
            for(int t = 0; t <= target; t++){
                int skip = prev[t];
                int take = 0;
                if(nums[i] <= t)
                    take = prev[t-nums[i]];

                curr[t] = take + skip;
            }

            prev = curr;
            curr = new int[target+1];
        }

        return prev[target];
    }

//    tabulation space optimization++
    private static int helper5(int[] nums){
        int[] prev = new int[target+1];

        Arrays.fill(prev, 0);
        prev[0] = 1;
        if(nums[0] <= target)
            prev[nums[0]] += 1;

        for(int i = 1; i < nums.length; i++){
            for(int t = target; t >= nums[i]; t--){
                prev[t] += prev[t-nums[i]];
            }
        }

        return prev[target];
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 2, 3, 0, 3, 0, 1};
        System.out.println(countPartitions(arr, 12));
    }
}
