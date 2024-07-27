import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        System.out.println(firstMissingPositive(nums));
    }

    static int firstMissingPositive(int[] nums) {
        int min = smallestPos(nums);

        if(min < 1)
            return 1;

        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));

        for(int i=0; i<nums.length; i++){
            if(nums[i] != i+1)
                return i+1;
        }
        return nums.length;
    }

    static void cyclicSort(int[] nums){
        int i=0;

        while(i < nums.length){
            if(nums[i] < 1 || nums[i] >= nums.length)
                i++;
            else if(nums[i] != nums[nums[i]-1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }
    }

    static int smallestPos(int[] nums){
        int min = 100000000;
        for(int x: nums) {
            if (x < 1)
                continue;
            min = min < x ? min : x;
        }
        return min;
    }

    static void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}