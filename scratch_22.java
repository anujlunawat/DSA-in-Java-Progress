class Scratch {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums));
    }
    static int firstMissingPositive(int[] nums) {
        boolean isOneThere = false;

        for(int x: nums)
            if (x==1){
                isOneThere = true;
                break;
            }

        if(!isOneThere)
            return 1;

        cyclicSort(nums);

        for(int i=0; i<nums.length; i++){
            if(nums[i] != i+1)
                return i+1;
        }
        return nums.length+1;
    }

    static void cyclicSort(int[] nums){
        int i=0;

        while(i < nums.length){
            if(nums[i] < 1 || nums[i] >= nums.length)
                i++;
            else if(nums[i] != nums[nums[i]-1]){
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = temp;
            }
            else
                i++;
        }
    }
}