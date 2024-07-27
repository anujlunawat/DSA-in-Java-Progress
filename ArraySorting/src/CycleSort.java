import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4,5, 6, 7,};
//        cycleSort(arr, 1, 5);
//        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr));
    }

    static void cycleSort(int[] arr, int start, int end){
        int i=0;
        while(i < arr.length - 1){
            int correctIndex = arr[i]-start;
            if( arr[i] != arr[correctIndex])
                swap(arr, i, arr[i] - start);
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

            if(mid < arr[mid])
                end = mid-1;
            else
                start = mid+1;
        }
        return start;
    }

}
