public class BinarySearchRecursion {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};

        System.out.println(binarySearchRec(nums, 0, nums.length-1, 8));
    }

    static int binarySearchRec(int[] nums, int start, int end, int target){

        if(end < 0 || start > nums.length-1)
            return -1;

        int mid = start + (end - start) / 2;

        if(nums[mid] == target)
            return mid;

        else if(nums[mid] > target)
            return binarySearchRec(nums, start, mid-1, target);

        else
            return binarySearchRec(nums, mid+1, end, target);
    }
}
