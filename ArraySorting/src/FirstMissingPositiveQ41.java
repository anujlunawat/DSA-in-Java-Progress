import java.util.Arrays;

public class FirstMissingPositiveQ41 {
    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 3, 4, 6};

        boolean isOneThere = false;
        // check if 1 is present in the array
        // if not, return 1 directly
        for(int x: nums){
            if (x == 1){
                isOneThere = true;
                break;
            }
        }
        if(!isOneThere)
            System.out.println(1);;

        cyclicSort(nums);

        System.out.println(Arrays.toString(nums));

        System.out.println(check(nums));
    }

    static void cyclicSort(int[] nums){
        int i=0;

        while(i < nums.length){
            if(nums[i] < 1 || nums[i] > nums.length - 1)
                i++;

            else if(nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);

            else i++;
        }
    }

    static void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    static int check(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1)
                return i+1;
        }
        return nums.length + 1;
    }
}
