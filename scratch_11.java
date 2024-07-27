import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] nums = {1,2,0};

        int smallest_pos_num = smallestPosNum(nums);

        if (smallest_pos_num != 1)
            System.out.println(1);

        cyclicSort(nums);
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
        return nums.length + 1;
    }
}