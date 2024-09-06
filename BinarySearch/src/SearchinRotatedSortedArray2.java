package src;

public class SearchinRotatedSortedArray2 {

    public static void main(String[] args){
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        int target = 2;

        int pivot_point = pivot(nums);

        System.out.println("pivot point = " + pivot_point);

        int first_try = binarySearch(nums, target, 0, pivot_point);

        System.out.println("first try = " + first_try);

        if(first_try == -1){
            System.out.println( binarySearch(nums, target, pivot_point+1, nums.length-1) != -1);
        }
        else System.out.println(true);
    }

    static int pivot(int[] arr){
        int start=0, end=arr.length-1;
        int firstEle = arr[0];

        while (start < end){
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid+1])
                return mid;

            else if(arr[mid] <= firstEle && mid != 0)
                end = mid-1;

            else
                start = start+1;
        }
        return start;
    }

    static int binarySearch(int[] arr, int target, int start, int end){
        while (start <= end){
            int mid = start + (end-start) / 2;

            if(arr[mid] == target)
                return mid;

            else if (target > arr[mid])
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
}
