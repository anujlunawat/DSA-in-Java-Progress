import java.util.Arrays;

public class BSRecursion {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6,7,8,12,29};
        int target = 12;
        System.out.println(binarySearch(nums, target));
        System.out.println(binarySearchRec(nums, target, 0, nums.length-1));
        System.out.println(binarySearchRec2(nums, target,0));
    }

    public static int binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }

    public static int binarySearchRec(int[] nums, int target, int start, int end){
        int mid = start + (end - start)/2;

        if(start > end)
            return -1;

        if(nums[mid] == target)
            return mid;
        else if(nums[mid] < target)
            return binarySearchRec(nums, target, mid+1, end);
        else
            return binarySearchRec(nums, target, start, mid-1);
    }

    public static int binarySearchRec2(int[] nums, int target, int i){
        int start = 0;
        int end = nums.length-1;
        int mid = start + (end - start)/2;

        if(start >= end && nums[mid] != target)
            return -1;

        if(nums[mid] == target)
            return mid+i;
        else if(nums[mid] < target)
            return binarySearchRec2(Arrays.copyOfRange(nums, mid+1, nums.length), target, i+mid+1);
        else
            return binarySearchRec2(Arrays.copyOfRange(nums, 0, mid), target, i);
    }
}
