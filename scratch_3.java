import java.util.Arrays;

class Solution {
    public static void main(String[] args){
        int[] arr = {5,7,7,8,8,1};
        System.out.println(Arrays.toString(searchRange(arr, 8)));
    }

    static int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int[] indices = new int[]{-1, -1};

        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] == target) {
                indices[0] = mid;
                end = mid-1;
            }
            else if(nums[mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }

        start = 0;
        end = nums.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] == target) {
                indices[1] = mid;
                start = mid+1;
            }
            else if(nums[mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }
        return indices;
    }
}