public class SmallestDivisorGivenThreshold1283 {
    public static void main(String[] args) {
        int[] nums = {200, 100, 14};
        int threshold = 10;

        System.out.println(smallestDivisor(nums, threshold));
    }

    static int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = maxMinEle(nums, true);

//        int ans = 0;

        if(threshold == nums.length)
            return end;
        else if(threshold == sum(nums))
            return start;

        while(start <= end){
            int mid = start + (end - start) / 2;
            int d = divide(nums, mid);

            if (d <= threshold) {
//                ans = mid;
                end = mid - 1;
            }
            else
                start = mid+1;
        }
//        return ans;
        return start;
    }

    static int divide(int[] nums, int n){
        int var = 0;

        for(int x: nums)
            var += Math.ceilDiv(x, n);
        return var;
    }

    static int maxMinEle(int[] nums, boolean max){
        int n = nums[0];

        for(int x: nums){
            if(max)
                n = x > n ? x : n;
            else
                 n = x < n ? x : n;
        }
        return n;
    }
    static int sum(int[] nums){
        int numsum = 0;

        for(int x: nums)
            numsum += x;
        return numsum;
    }
}
