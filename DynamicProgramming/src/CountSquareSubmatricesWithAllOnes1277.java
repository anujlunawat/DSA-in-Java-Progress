//not completed

public class CountSquareSubmatricesWithAllOnes1277 {
    public static int countSquares(int[][] matrix) {
        int count = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                count += helper(i, i, j, j, matrix);
            }
        }

        return count;
    }
    private static int helper(int start_row, int end_row, int start_col, int end_col, int[][] matrix){
        if(start_row > matrix.length-1 || end_row > matrix.length-1 || start_col > matrix[0].length-1 || end_col > matrix[0].length-1)
            return 0;

        int count = 0;

        if(conditions(start_row, end_row, start_col, end_col, matrix)) {
            count += 1 + helper(start_row, end_row+1, start_col, end_col+1, matrix);
        }

        return count;
    }

    private static boolean conditions(int start_row, int end_row, int start_col, int end_col, int[][] matrix){
        if(end_row > matrix.length-1 || end_col > matrix[0].length-1)
            return false;

        for(int i = start_col; i <= end_col; i++){
            if(matrix[end_row][i] != 1)
                return false;
        }
        for(int i = start_row; i <= end_row; i++){
            if(matrix[i][end_col] != 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1},
                {1, 1}
        };
        System.out.println(countSquares(matrix));
    }
}
