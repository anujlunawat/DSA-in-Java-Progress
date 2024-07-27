import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem268CyclicSort {
    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>();
        int[] arr = {9,6,4,2,3,5,7,0,1};
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
        if (arr[0] != 0)
            System.out.println(0);
        else
            System.out.println(binarySearch(arr));
    }

    static void cycleSort(int[] arr){
        int i=0;

        while(i < arr.length){
            if(arr[i] != i && arr[i] < arr.length)
                swap(arr, arr[i], i);
            else i++;
        }
    }

     static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static int binarySearch(int[] arr){
        int start = 0, end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > arr[mid+1])
                return mid;

            else if(arr[mid] < arr[mid+1] && arr[mid] > arr[0])
                end = mid-1;
            else
                start = mid+1;
        }
        return arr.length;
    }
}
