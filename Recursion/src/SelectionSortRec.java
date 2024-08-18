import java.util.Arrays;

public class SelectionSortRec {
    public static void main(String[] args) {
        int[] nums = {5,4,2,1,3};
        selectionSort(nums, 0, 1, 0);
        System.out.println(Arrays.toString(nums));
    }

    static void selectionSort(int[] nums, int max_ind, int curr_ind, int done){
        if(done >= nums.length-1)
            return;
        if(curr_ind < nums.length-done){
            if(nums[max_ind] < nums[curr_ind]){
                max_ind = curr_ind;
            }
            selectionSort(nums, max_ind, curr_ind+1, done);
        }
        else{
            int temp = nums[curr_ind-1];
            nums[curr_ind-1] = nums[max_ind];
            nums[max_ind] = temp;
            selectionSort(nums, 0, 1, done+1);
        }
    }
}
