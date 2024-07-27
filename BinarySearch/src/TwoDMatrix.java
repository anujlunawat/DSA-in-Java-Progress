import java.lang.reflect.Array;
import java.util.Arrays;

public class TwoDMatrix {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        };
//        int target = 2;
//
//        System.out.println(Arrays.toString(search(matrix, target)));
        int[] arr1 = {1,2,3};
        int[] arr2 = {4,5,6};

    }

    static int[] search(int[][] matrix, int target){
        int start = 0, end = (matrix.length * matrix[0].length) - 1;

        while(start <= end){
            int mid = start + (end-start)/2;
            int row = mid / matrix.length, col = mid % matrix[0].length;

            if(matrix[row][col] == target)
                return new int[] {row, col};
            else if(matrix[row][col] > target)
                end = mid-1;
            else
                start = mid+1;
        }
        return new int[]{-1, -1};
    }
}
