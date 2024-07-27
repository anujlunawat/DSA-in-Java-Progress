import java.util.Arrays;

public class RecursiveBS {
    public static void main(String[] args){
        int[] arr = {1,10,19,20,21,45,57,68,79,80};
        System.out.println(recursiveBS(arr, 80, 0, arr.length-1));
        System.out.println(recursiveBS(arr, 1, -1));
    }

    static int recursiveBS(int[] arr, int target, int start_ind, int end_ind){
        int midpoint = start_ind + (end_ind-start_ind)/2;

        if (start_ind>end_ind )
            return -1;
        else if (arr[midpoint] == target)
            return midpoint;
        else if (target > arr[midpoint])
            return recursiveBS(arr, target, midpoint+1, end_ind);

        return recursiveBS(arr, target, start_ind, midpoint-1);
    }

    static int recursiveBS(int[] arr, int target, int index){
        int midpoint = (arr.length - 1) >>> 1;

        if (arr.length == 0)
            return index + 1;

        else if (arr[midpoint] == target)
            return midpoint;
        else if (target > arr[midpoint])
            return recursiveBS(Arrays.copyOfRange(arr, midpoint+1, arr.length), target, (midpoint + ((arr.length-1 -midpoint)/2) + 1));

        return recursiveBS(Arrays.copyOfRange(arr, 0, midpoint), target, index);
    }
}
