import java.util.Arrays;

public class InfiniteSortedArray {
    public static void main(String[] args){
        int[] arr = {1,2,4,5,6,12,15,19,20,23,29,30, 35, 39, 45, 49, 51, 60, 65, 79};
        int target = 19;
        int index = infiniteSortedArray(arr, target);
        System.out.println(index);
        System.out.println(arr[index]);
    }

    static int infiniteSortedArray(int[] arr, final int target){
        int start=0, end=1;

        while (true){
            if(target > arr[end]){
                start = end+1;
                end*=2;
            }
            if(target < arr[end]){
                return start + binarySearch(Arrays.copyOfRange(arr, start, end), target);
            }
        }
    }

    static int binarySearch(int[] arr, final int target){
        int start=0, end=arr.length;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid] == target)
                return mid;
            else if (arr[mid]<target)
                start = mid+1;
            else
                end = mid-1;
        }
        return start;
    }

}
