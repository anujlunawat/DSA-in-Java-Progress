import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        int[] ans = mergeSort(arr);
        System.out.println(Arrays.toString(ans));

        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static int[] mergeSort(int[] arr){
        if(arr.length == 1)
            return arr;

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second){
        int[] mix = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < first.length && j < second.length){
            if (first[i] < second[j]){
                mix[k] = first[i];
                i++;
            }
            else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }

    static void mergeSortInPlace(int[] arr, int start, int end){
        if(end-start <= 1)
            return;

        int mid = start + (end - start) / 2;

        mergeSortInPlace(arr, start, mid-1);
        mergeSortInPlace(arr, mid, end);

        mergeInPlace(arr, start, end);
    }

    static void mergeInPlace(int[] arr, int start, int end){
        int[] mix = new int[end - start];

        int mid = start + (end-start)/2;

        int i = start;
        int j = mid;
        int k = 0;

        while(i < mid && j < end){
            if(arr[j] < arr[i]){
                mix[k] = arr[j];
                j++;
            }
            else {
                mix[k] = arr[i];
                i++;
            }
            k++;
        }

        while (i < mid){
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < end){
            mix[k] = arr[j];
            j++;
            k++;
        }

        System.arraycopy(mix, 0, arr, start, mix.length);
//        if (end + 1 - start >= 0) System.arraycopy(mix, start, arr, start, end + 1 - start);
    }
}
