class Scratch {
    public static void main(String[] args) {
        
    }

    public int[] searchRange(int[] nums, int target) {
        int[] indices = {-1, -1};
        indices[0] = search(nums, target, indices, true);
        indices[1] = search(nums, target, indices, false);
        return indices;
    }

    int search(int[] nums, int target, int[] indices, boolean goLeft){
        int start=0, end=nums.length-1;
        boolean isThere = false;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(nums[mid] == target){
                if(goLeft)
                    end = mid - 1;

                else
                    start = mid+1;
            }

            else if(nums[mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }
        if(goLeft)
            return start;
        return end;
    }




    int[] arr = {0, -1};

        int start = 0, end = nums.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] == x){
                arr[0] = mid;
                end = mid-1;
            }
            else if(nums[mid] > x)
                end = mid-1;
            else
                start = mid+1;
        }

        start = 0; end = nums.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] == x){
                arr[1] = mid;
                start = mid+1;
            }
            else if(nums[mid] > x)
                end = mid-1;
            else
                start = mid+1;
        }

        return (arr[1]-arr[0] + 1);
}