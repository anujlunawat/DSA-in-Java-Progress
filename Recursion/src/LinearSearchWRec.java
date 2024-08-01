import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinearSearchWRec {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3};
        int target = 3;
        System.out.println(linearSearch(arr, target, 0));
        System.out.println(linearSearch(arr, target, 0, new ArrayList<>()));
        System.out.println(linearSearch2(arr, target, 0));
    }

//    find the first occurrence
    static int linearSearch(int[] arr, int target, int ind){
        if(ind >= arr.length)
            return -1;
        if(arr[ind] == target)
            return ind;
        return linearSearch(arr, target, ind+1);
    }

//    find all indices
    static ArrayList<Integer> linearSearch(int[] arr, int target, int ind, ArrayList<Integer> indices){
        if(ind >= arr.length)
            return indices;

        if(arr[ind] == target)
            indices.add(ind);
        return linearSearch(arr, target, ind+1, indices);
    }

    static ArrayList<Integer> linearSearch2(int[] arr, int target, int ind){
        ArrayList<Integer> indices = new ArrayList<>();

        if(ind >= arr.length)
            return indices;

        if(arr[ind] == target){
            indices.add(ind);
            indices.addAll(linearSearch2(arr, target, ind+1));
            return indices;
        }
        return linearSearch2(arr, target, ind+1);
    }
}
