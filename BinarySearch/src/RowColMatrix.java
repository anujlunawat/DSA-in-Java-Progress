import java.util.Arrays;

public class RowColMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50},
                {35, 38, 40, 100}
        };

        System.out.println(Arrays.toString(search(matrix, 20)));
    }

    static int[] search(int[][] matrix, final int target){
        int row = 0;
        int col = matrix[0].length - 1;

        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target)
                return new int[]{row, col};
            else if(matrix[row][col] < target)
                row++;
            else
                col--;
        }
        return new int[]{-1, -1};
    }
}
