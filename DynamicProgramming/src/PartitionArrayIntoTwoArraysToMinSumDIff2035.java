public class PartitionArrayIntoTwoArraysToMinSumDIff2035 {
    public static int minimumDifference(int[] nums) {
        int total_sum = 0;
        for(int i = 0; i < nums.length; i++){
//            nums[i] = Math.abs(nums[i]);
            total_sum += nums[i];
        }

        int target = total_sum / 2;

//        partition 1
        int p1 = target - helper(nums.length-1, target, nums);
//        partition 2
        int p2 = total_sum - p1;
        return p2-p1;
    }

    private static int helper(int ind, int target, int[] nums){
        if(target == 0)
            return 0;
        if(ind == 0){
            if(nums[ind] <= target)
                return target - nums[ind];
            return target;
        }

        int take = Integer.MAX_VALUE;
        int skip = helper(ind-1, target, nums);
        if(nums[ind] <= target)
            take = helper(ind-1, target - nums[ind], nums);

        return Math.min(take, skip);
    }

    public static void main(String[] args) {
        int[] nums = {2,-1,0,4,-2,-9};
        System.out.println(minimumDifference(nums));
    }
}
