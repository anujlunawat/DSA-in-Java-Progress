import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1, -1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int[] max = maxValue(arr, arr.length-i);

            int temp = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = max[1];
            arr[max[0]] = temp;
        }
    }

    static int[] maxValue(int[] arr, int end){
//        it does not need to pass the value
//        but i did it so nw
        int[] max=new int[]{0, arr[0]};

        for (int i = 0; i < end; i++) {
            max = max[1] < arr[i] ? new int[]{i, arr[i]} : max;
        }
        return max;
    }
}
