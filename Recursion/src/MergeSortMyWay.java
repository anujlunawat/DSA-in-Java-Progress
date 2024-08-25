import java.util.Arrays;

class MergeSortMyWay {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
//        mergeSortInPlace(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSortInPlace(int[] arr, int start, int end){
        if (end - start == 0)
            return;

        int mid = start + (end - start) / 2;

        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid+1, end);

//        pass the starting indices of the 2 subarrays
        merge(arr, start, mid+1, end);
    }

    static void merge(int[] arr, int start, int mid, int end){
        int[] mix = new int[(end - start)+ 1];

        int i = start;
        int j = mid;
        int k = 0;

        while(i < mid && j <= end){
            if(arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            }
            else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid){
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j <= end){
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int value : mix) {
            arr[start++] = value;
        }

    }
}