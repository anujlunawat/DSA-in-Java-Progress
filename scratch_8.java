import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Scratch {
    public static void main(String[] args) {
        int[] nums = {
            2,2
        };

        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(missingNumbers(nums));
    }

    static void cyclicSort(int[] arr){
        int i=0;
        int start = 1;
        while(i < arr.length){
            if(arr[i] != i + start && arr[arr[i] - start] != arr[i])
                swap(arr, arr[i] - start, i);
            else i++;
        }
    }

    static void swap(int[] nums, int x, int y){
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
    }

    static List<Integer> missingNumbers(int arr[]){
        List<Integer> ans = new ArrayList<>();

        for (int i=0; i<arr.length; i++)
            if (arr[i] != i+1)
                ans.add(i + 1);
        return ans;
    }

}