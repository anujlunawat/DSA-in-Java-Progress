class Scratch {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(searchRangeLeft(nums, 6, true) + ", " + searchRangeLeft(nums, 5, false));
    }
    static int searchRangeLeft(int[] nums, int target, boolean isLeft){
        int start=0, end=nums.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] == target) {
                if (isLeft)
                    end = mid - 1;
                else
                    start = mid+1;
            }
            else if(nums[mid] < target)
                start=mid+1;
            else
                end=mid-1;
        }
        if(nums[start] == target) {
            if (isLeft)
                return start;
            else if (nums[end] == target)
                return end;
        }
        return -1;
    }
}