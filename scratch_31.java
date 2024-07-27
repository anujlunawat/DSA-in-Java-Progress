import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] nums = new int[]{5,2,11,23,1,0,7,19};
//        bubbleSortLtR(nums);
        bubbleSortRtL(nums);
        System.out.println(Arrays.toString(nums));
    }


    static void bubbleSortLtR(int[] nums){
        for(int i=0; i < nums.length-1; i++){
            for(int j=1; j<nums.length-i; j++){
                if(nums[j] < nums[j-1]){
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    static void bubbleSortRtL(int[] nums){
        for(int i=nums.length-1; i > 0; i--){
            for(int j = nums.length-1; j > (nums.length - i) - 1; j--){
                if(nums[j] < nums[j-1]){
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}