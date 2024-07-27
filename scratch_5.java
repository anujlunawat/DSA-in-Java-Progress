import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] arr = {3, 3};
        int target=6;

        System.out.println(Arrays.toString(twoSum(arr, target)));
        
    }
    static int[] twoSum(int[] nums, int target) {
        int start=0, end=nums.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if (nums[mid] <= target){
                int s=0, e=nums.length-1;

                while(s <= e){
                    int m = s + (e-s)/2;
                    if (m==mid) continue;
                    if(nums[m] + nums[mid] == target)
                        return new int[]{mid, m};
                }
            }
            else
                end = mid-1;
        }
        return new int[]{-1, -1};
    }
}