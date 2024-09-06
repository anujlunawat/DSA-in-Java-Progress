package src;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,1,2};
        int target=5;

        int peak = peakElement(nums);

        System.out.println("Peak = " + peak);

//        int inc = binarySearch(nums, target, 0, peak);
//
//        if (inc==-1)
//            System.out.println(binarySearch(nums, target, peak+1, nums.length-1));
//        else
//            System.out.println(inc);
    }

     static int peakElement(int[] arr){
        int start=0, end=arr.length-1;
        int first_ele = arr[0];

        while (start < end){
            int mid = start + (end - start)/2;

            if(arr[mid] > arr[mid+1])
                return mid;

            else if(arr[mid] < first_ele)
                end = mid-1;
            else
                start = mid+1;
        }
        return start;
    }

    static int binarySearch(int[] mountainArr, int target, int start, int end){
        while (start <= end){
            int mid = start + (end-start)/2;

            if(mountainArr[mid] == target)
                return mid;

            else if (mountainArr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;

    }
}
