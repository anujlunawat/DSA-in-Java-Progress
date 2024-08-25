public class CheckIfSorted {
    public static void main(String[] args) {
        int[] arr = {1,0};
        System.out.println(isSorted(arr, 0));
        System.out.println(isSorted2(arr, 0));
    }

    static boolean isSorted(int[] arr, int ind){
        if(ind >= arr.length - 1)
            return true;

        return (arr[ind] < arr[ind+1]) && isSorted(arr, ++ind);
    }
    static boolean isSorted2(int[] arr, int ind){
        if(ind >= arr.length - 1)
            return true;

        if(arr[0] < arr[arr.length-1]){
            return (arr[ind] < arr[ind+1]) && isSorted2(arr, ++ind);
        }

        return (arr[ind] > arr[ind+1]) && isSorted2(arr, ++ind);
    }
}
