public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(Sorted(arr, 0));
    }

    static boolean Sorted(int[] arr, int index){
        if (index >= arr.length - 1)
            return true;
        return (arr[index] <= arr[index+1]) && Sorted(arr, index+1);
    }
}
