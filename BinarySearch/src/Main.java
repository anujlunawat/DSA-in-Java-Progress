//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{-19, -7, -1, 0, 1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarysearch(arr, -17));

    }

    static int binarysearch(int[] arr, int target){
        int start_index = 0, end_index = arr.length-1;


        while(start_index <= end_index){
            int mid_index = (end_index + start_index) / 2;

            if (arr[mid_index] == target) return mid_index;
            else if (arr[mid_index] > target) end_index = mid_index-1;
            else start_index = mid_index+1;
        }
        return -1;
    }
}