import java.util.ArrayList;
import java.util.Arrays;

public class SearchInsertPosition {
    public static void main(String[] args){
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 15;
        System.out.println(searchIndexPos(arr, target));
        System.out.println(searchIndexPosRec(arr, target, 0, arr.length-1));
        System.out.println(searchIndexPos2(arr, target));
//        System.out.println(searchIndexPosRec(arr, 5, (arr.length-1)/2));
    }

    static int searchIndexPos(int[] arr, final int target){
        int start_index = 0, end_index = arr.length-1;
        int ans=arr.length;

        while(start_index <= end_index){

            int mid_index = start_index + (end_index - start_index) / 2;

             if (arr[mid_index] >= target){
                 ans = mid_index;
                 end_index = mid_index-1;
             }
             else
                 start_index = mid_index+1;
        }
        return ans;
    }

    static int searchIndexPosRec(int[] arr, final int target, int start_index, int end_index){
        int  mid_index = ((start_index + (end_index - start_index) / 2));

        if (end_index < start_index)
            return start_index;

        else if (arr[mid_index] == target)
            return mid_index;

        else if(arr[mid_index] > target)
            return searchIndexPosRec(arr, target, start_index, mid_index - 1);
        return searchIndexPosRec(arr, target, mid_index + 1, end_index);
    }

    static int searchIndexPos2(int[] arr, final int target){
        int start=0, end=arr.length-1;

        while (start <= end){
            int midpoint = start + (end - start) / 2;

             if (arr[midpoint] == target)
                 return midpoint;

             else if (arr[midpoint] > target)
                 end = midpoint - 1;
             else
                 start = midpoint + 1;
        }
        return start;
    }

















//    static int searchIndexPosRec(int[] arr, final int target, int ans){
//        int midpoint = (arr.length - 1) / 2;
//
//        if(arr.length == 0)
//            return ans+1;
//        else if (arr[midpoint] == target)
//            return ans;
//        else if (arr[midpoint] > target){
//            return searchIndexPosRec(Arrays.copyOfRange(arr, 0, midpoint), target, (ans + (midpoint - 1) / 2));
//        }
//        return searchIndexPosRec(Arrays.copyOfRange(arr, midpoint+1, arr.length), target, (ans + (arr.length -1 - midpoint-1) / 2));
////        ans + (arr.length -1 - midpoint-1) / 2
////        ans + ((arr.length-1 - midpoint)/2)
////        (ans - ((midpoint-1)/2) + 1)
//    }
}
