public class kokoEatingBananas875 {
    public static void main(String[] args) {
        int[] nums = {805306368,805306368,805306368};
        int h = 1000000000;
        System.out.println(minEatingSpeed(nums, h));
    }

    static int minEatingSpeed(int[] nums, int h) {
        int start = 1;
        int end = maxEle(nums);
//        int ans = 0;

//        while(start <= end){
//            int mid = start + (end - start) / 2;
//
//            if(complete(nums, mid, h)){
////                ans = mid;
//                end = mid-1;
//            }
//            else
//                start = mid+1;
//        }
////        return ans;
//        return start;
//    }
        while(start < end){
            int mid = start + (end - start) / 2;

            if(complete(nums, mid, h)){
                // ans = mid;

                end = mid;
            }
            else
                start = mid+1;
        }
        // return ans;
        return end;
    }

    static boolean complete(int[] nums, int k, int h){
        int pile = 0;
        long hours = 0;

        while(pile < nums.length){
            hours += Math.ceilDiv(nums[pile], k);
            pile++;
        }

        if(hours > h)
            return false;
        return true;

    }

    static int maxEle(int[] nums){
        int max = nums[0];
        for(int x: nums)
            max = x>max ? x : max;
        return max;
    }
}