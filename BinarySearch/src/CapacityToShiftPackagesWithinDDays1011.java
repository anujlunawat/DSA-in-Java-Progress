public class CapacityToShiftPackagesWithinDDays1011 {
    public static void main(String[] args) {
        int[] weights = {1,2,3,1,1};
        int days = 4;

        System.out.println(shipWithinDays(weights, days));
    }

    static int shipWithinDays(int[] weights, int days){
        int start = maxMinEle(weights, true);
        int end = sum(weights);
        int ans = -1;

        if(days == 1)
            return end;
        else if(days >= weights.length)
            return start;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(weightForDays(weights, days, mid)){
                ans = mid;
                end = mid-1;
            }
            else
                start = mid+1;
        }
        return ans;
    }

    static boolean weightForDays(int[] weights, int days, int mid){
        int d = 0;
        int combined_weight = mid;

        int i=0;
        while(i < weights.length){
            if(combined_weight >= weights[i]) {
                combined_weight -= weights[i];
                i++;
            }
            else{
                d++;
                combined_weight = mid;
            }
        }

        if(combined_weight != mid)
            d++;
        return d <= days;
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
