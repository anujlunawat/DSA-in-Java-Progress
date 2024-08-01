import java.util.Arrays;

public class BubbleSortRec {
    public static void main(String[] args) {
        int[] nums = {5,19,7,4,1,0};
        bubbleSort(nums, 0, 0);
        System.out.println(Arrays.toString(nums));
    }

    static void bubbleSort(int[] nums, int ptr, int i){
        if(ptr >= nums.length-1)
            return;

        if(i <= nums.length-2-ptr){
            if(nums[i] > nums[i+1]){
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
            bubbleSort(nums, ptr, i+1);
        }

        else{
            bubbleSort(nums, ptr+1, 0);
        }
    }
}
