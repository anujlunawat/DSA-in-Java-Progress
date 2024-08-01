public class isArraySorted {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4,5};
        System.out.println(isSorted(arr, 0));
    }

    static boolean isSorted(int[] arr, int p){
        if(p >= arr.length-1)
            return true;
        return (arr[p] <= arr[p+1]) && isSorted(arr, p+1);
    }
}
