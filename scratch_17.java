class Scratch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 10, 11, 13, 15};
        System.out.println(lowerBound(nums, 12));

    }
    static int lowerBound(int[] nums, int target){
        int start=0, end=nums.length-1;

        while(start <= end){
           int mid = start + (end-start) / 2;

           if(nums[mid] == target)
               return mid;
           else if(nums[mid] > target)
               end = mid-1;
           else
               start = mid+1;
        }
        return start;
    }
}