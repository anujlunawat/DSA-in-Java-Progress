import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr){
        boolean swap;

        for(int i=0; i < arr.length-1; i++){
            swap = false;
            for(int j=1; j < arr.length-i; j++){

                if(arr[j] < arr[j-1]){
//                    is the swap happening
                    swap = true;
//                    swap
                    int t = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = t;
                }
            }
//            if no swap takes place for a particular value of i,
//            it means that the array is sorted. So break through the program.
            if(!swap)
                break;
        }
    }
}
