import java.util.Arrays;

public class CheckIfSorted {
    public static void main(String[] args){
        int[] arr = new int[]{1,1,1,1,1}, arr2 = {10, 20, 30, 40, 55, 67, 89}, arr3 = {90, 80, 70, 67, 60, 50};
        int[] unsorted_arr = new int[]{0, 3, 5, 1, 7, 2, 8, 3, 2, 4, 5 };
        System.out.println(checkIfSorted(arr));
        System.out.println(checkIfSorted(arr2));
        System.out.println(checkIfSorted(arr3));
        System.out.println(checkIfSorted(unsorted_arr));
    }

    static boolean checkIfSorted(int[] arr){
//        time complexity: O(n)
//        iterative approach
        boolean isAsc = arr[0] < arr[arr.length -1];
        if (isAsc){
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] > arr[i+1])
                    return false;
            }
        }
        else{
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] < arr[i+1])
                    return false;
            }
        }
        return true;
    }
}
