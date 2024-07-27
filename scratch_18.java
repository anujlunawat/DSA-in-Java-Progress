import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,2,3};
        System.out.println(Arrays.toString(count(nums, nums.length, 2)));
    }

    static int[] count(int[] nums, int n, int x) {
        int[] arr = {0, 0};

        int start = 0, end = nums.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] == x){
                arr[0] = mid;
                end = mid-1;
            }
            else if(nums[mid] > x)
                end = mid-1;
            else
                start = mid+1;
        }

        start=0;end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] == x){
                arr[1] = mid;
                start = mid+1;
            }
            else if(nums[mid] > x)
                end = mid-1;
            else
                start = mid+1;
        }

        return arr;

    }
}