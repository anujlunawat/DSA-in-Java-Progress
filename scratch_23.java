class Scratch {
    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 5, 6, 7, 11, 15, 17, 18, 19};
//        System.out.println(binarySearch(nums, 16));
//        System.out.println(nums[floor(nums, 16)]);
//        System.out.println(nums[ceil(nums, 16)]);
        System.out.println(squareRoot(200));
    }

    static int binarySearch(int[] nums, int target){
        int start=0, end=nums.length-1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }

    static int floor(int[] nums, int target){
        int start=0, end=nums.length-1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        return end;
    }

    static int ceil(int[] nums, int target){
        int start=0, end=nums.length-1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }
        return start;
    }

    static int squareRoot(int target){
        int start=0, end = (target/2) + 1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(mid * mid == target)
                return mid;
            else if(mid*mid > target)
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }
}