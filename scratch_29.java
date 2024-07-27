import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] nums = {5,4,8,11,3,2,10,1};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    static void insertionSort(int[] nums){
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j>0; j--){
                if(nums[j] < nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
                else
                    break;
            }
        }
    }
}