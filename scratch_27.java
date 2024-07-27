import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] nums = {332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184};
        int h = 823855818;
        System.out.println(minEatingSpeed(nums, h));
    }

    static int minEatingSpeed(int[] nums, int h) {
        int start = 2;
        int max = maxEle(nums);
        int end = 3;
        int ans = 0;

        while (start <= end) {
            if(start == end && end <= max/2 + 1) {
                start = end + 1;
                end *= 2;
            }

            int mid = start + (end - start) / 2;

            if (complete(nums, mid, h)) {
                ans = mid;
                end = mid - 1;
            } else
                start = mid + 1;

        }
        return ans;
    }

    static boolean complete(int[] n, int k, int h){
        int pile = 0;
        int[] nums = n.clone();
        int[] zeroes = new int[nums.length];

        for(int i = 0; i < h && pile < nums.length; i++){
            if(Arrays.compare(zeroes, nums) == 0)
                break;

            for(int j=0;j<nums.length;j++){
                nums[j] = nums[j] > k ? nums[j]-k : 0;
            }
//            if(nums[pile] > k)
//                nums[pile] -= k;
//            else {
//                nums[pile] = 0;
//                pile++;
//            }
        }

        if(Arrays.compare(zeroes, nums) == 0)
            return true;
        return false;
    }

    static int maxEle(int[] nums){
        int max = nums[0];
        for(int x: nums)
            max = x>max ? x : max;
        return max;
    }
}