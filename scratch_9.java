import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] nums = {3,2,3,4,6,5};
        cyclicSort(nums);
//        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(rep(nums)));
    }

    static void cyclicSort(int[] nums){
        int i=0;

        while(i < nums.length){
            int correct = nums[i] - 1 ;
            if(nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else i++;
        }
    }

    static int[] rep(int[] nums){
        for (int i=0; i<nums.length; i++)
            if (nums[i] != i + 1)
                return new int[]{nums[i], i+1};
//            if (nums[i] != i+1) {
//                if (i == nums[i])
//                    return new int[]{nums[i], nums[i] + 1};
//                return new int[]{nums[i], nums[i] - 1};
            return new int[]{-1, -1};
    }
}