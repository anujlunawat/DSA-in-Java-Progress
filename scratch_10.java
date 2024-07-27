import java.lang.reflect.Array;
import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] nums = {7,8,9,11,12};
        cyclicSort(nums, smallestPosNum(nums));
        System.out.println(Arrays.toString(nums));
        System.out.println(check(nums));
    }

    static void cyclicSort(int[] nums, int start){
        int i = 0;
        int j = nums.length - 1;

        while(i < nums.length){
            if(nums[i] - start > nums.length -1) {
                i++;
                continue;
            }
            if(nums[i] > 0 && nums[i] != nums[nums[i] - start])
                swap(nums, i, nums[i] - start);
            else
                i++;
        }
    }

    static void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    static int smallestPosNum(int[] nums){
        int min = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                if(min == -1)
                    min = nums[i];
                else
                    min = min < nums[i] ? min : nums[i];
            }

        }
        return min;
    }


    static int check(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1)
                return i+1;
        }
        return -1;
    }

}