import java.util.Arrays;

public class BoundsBS {
    public static void main(String[] args){
        int[] arr = {-11, -9, -3, -1, 0, 3, 6, 9, 10, 11};
        System.out.println(lowerBound(arr, 1));
        System.out.println(lowerBoundRecursive(arr, 12, 0, arr.length-1));
//        System.out.println(Arrays.binarySearch(arr, -2));
//        System.out.println(Arrays.compare(arr, new int[]{1,2,3}));
//        System.out.println(Arrays.toString(Arrays.copyOf(arr, 5)));
//        int[] arr2 = Arrays.copyOfRange(arr, 4, 8);
//        System.out.println("arr reference: " + arr);
//        System.out.println("arr2 reference: " + arr2);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr2));

    }

    static int lowerBound(int[] arr, int target){
        int ans = arr.length-1;
        int start=0, end = arr.length-1;

        while (start <= end) {
            int midpoint = start + (end - start)/2;

            if (arr[midpoint] >= target) {
                ans = midpoint;
                end = midpoint - 1;
            }
            else start = midpoint + 1;
        }
        return ans;
    }


    static int lowerBoundRecursive(int[] arr, final int target, int start, int end){
        int midpoint = start + (end - start) / 2;

        if (start > end)
            return midpoint;

        else if (arr[midpoint] ==  target)
            return midpoint;
        else if (arr[midpoint] > target)
            return lowerBoundRecursive(arr, target, start, midpoint-1);
        return lowerBoundRecursive(arr, target, midpoint+1, end);
    }
}
