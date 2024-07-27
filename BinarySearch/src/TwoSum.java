import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args){
        int[] arr ={-1,-2,-3,-4,-5};
        System.out.println(Arrays.toString(twoSum(arr, -8)));
    }

    static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for (int j = 0; j < nums.length; j++) {
                if (j==i) continue;
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }return new int[]{-1, -1};
    }

    static int[] twoSum2(int[] nums, int target){
        Arrays.sort(nums);

        while (true){

        }
    }
}
