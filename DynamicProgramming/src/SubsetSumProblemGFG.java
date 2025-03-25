import java.util.Arrays;

public class SubsetSumProblemGFG {
    static Boolean isSubsetSum(int[] arr, int sum) {
        ans = new Boolean[arr.length][sum+1];
        for(int i = 0; i < ans.length; i++)
            Arrays.fill(ans[i], false);
//        return helper2(arr.length-1, sum, arr);
//        return helper3(arr, sum);
        return helper4(arr, sum);
    }

//    recursion
    static boolean helper(int i, int sum, int[] arr){
        if(sum < 0)
            return false;
        if(sum == 0)
            return true;
        if(i == 0)
            return sum - arr[i] == 0;

        boolean take = helper(i-1, sum-arr[i], arr);
        boolean skip = helper(i-1, sum, arr);
        return take || skip;
    }

//    memoization
    static Boolean[][] ans;
    static boolean helper2(int i, int sum, int[] arr){
        if(sum < 0)
            return false;
        if(sum == 0)
            return true;
        if(i == 0)
            return sum - arr[i] == 0;
        if(ans[i][sum] != null)
            return ans[i][sum];

        boolean take = helper2(i-1, sum-arr[i], arr);
        boolean skip = helper2(i-1, sum, arr);
        return ans[i][sum] = take || skip;
    }

//    tabulation
    static boolean helper3(int[] arr, int sum){
        for(int i = 0; i < ans.length; i++)
            ans[i][0] = true;
        if(ans[0].length > arr[0])
            ans[0][arr[0]] = true;

        for(int i = 1; i < ans.length; i++){
            for(int target = 1; target <= sum; target++){
                boolean skip = ans[i-1][target];
                boolean take = false;
                if(arr[i] <= target) take = ans[i-1][target-arr[i]];
                ans[i][target] = take || skip;
            }
        }
        return ans[arr.length-1][sum];
    }

//    tabulation space optimization
    static boolean helper4(int[] arr, int sum){
        boolean[] curr = new boolean[sum+1];
        boolean[] prev = new boolean[sum+1];

        if(sum >= arr[0])
            prev[arr[0]] = true;
        prev[0] = curr[0] = true;

        for(int i = 1; i < ans.length; i++){
            for(int target = 1; target <= sum; target++){
                boolean skip = prev[target];
                boolean take = false;
                if(arr[i] <= target) take = prev[target-arr[i]];
                curr[target] = take || skip;
            }
            prev = curr;
            curr = new boolean[sum+1];
            curr[0] = true;
        }
        return prev[sum];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(isSubsetSum(arr, 80));
    }
}
