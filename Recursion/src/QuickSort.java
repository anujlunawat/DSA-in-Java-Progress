import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    static void quickSort(int[] nums, int lo, int hi){
        if(lo >= hi)
            return;

        int start = lo;
        int end = hi;
        int mid = start + (end - start) / 2;
        int pivot = nums[mid];

        while(start <= end){
            while(nums[start] < pivot)
                start++;

            while(nums[end] > pivot)
                end--;

            if(start <= end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        quickSort(nums, lo, end);
        quickSort(nums, start, hi);
    }
}
