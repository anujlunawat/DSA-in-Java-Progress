import java.util.Arrays;

public class MaxPathSumInMatrixCode360 {
    static int[][] arr;

    public static int getMaxPathSum(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        arr = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], -1);
        }
//        for (int i = 0; i < matrix[0].length; i++) {
//            max = Math.max(max, helper(matrix.length - 1, i, matrix));
//        }
//        return max;
        return helper2(matrix);
    }

    //    recursion -> memoization
    private static int helper(int r, int c, int[][] matrix) {
        if (r < 0 || c < 0 || c > matrix[0].length - 1)
            return Integer.MIN_VALUE;
        if (r == 0)
            return matrix[r][c];
        if (arr[r][c] != -1)
            return arr[r][c];
//         go up
        int up = helper(r - 1, c, matrix);

//        go up left diagonal
        int left_diag = helper(r - 1, c - 1, matrix);

//        go up right diagonal
        int right_diagonal = helper(r - 1, c + 1, matrix);

        return arr[r][c] = Math.max(up, Math.max(left_diag, right_diagonal)) + matrix[r][c];
    }

    //    tabulation
    private static int helper2(int[][] matrix) {
        arr[0] = matrix[0];

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int up = arr[i - 1][j];
                int left_diag = Integer.MIN_VALUE;
                int right_diag = Integer.MIN_VALUE;
                if (j > 0)
                    left_diag = arr[i - 1][j - 1];
                if (j < arr[0].length - 1)
                    right_diag = arr[i - 1][j + 1];
                arr[i][j] = Math.max(up, Math.max(left_diag, right_diag)) + matrix[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int c = 0; c < arr[0].length; c++) {
            max = Math.max(max, arr[arr.length - 1][c]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 2, 3},
                {3, 7, 2},
                {8, 1, 5}
        };

        System.out.println(getMaxPathSum(matrix));
    }
}
