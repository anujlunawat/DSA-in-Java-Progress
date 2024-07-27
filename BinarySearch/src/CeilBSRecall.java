package src;

public class CeilBSRecall {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7, 11, 19, 21, 22, 23, 24};
        System.out.println(floorBS(nums, 25));
    }

    public static int floorBS(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }
        return start;
    }
}