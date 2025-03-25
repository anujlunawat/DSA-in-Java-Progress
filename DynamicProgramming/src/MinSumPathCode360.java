import java.util.Arrays;

public class MinSumPathCode360 {

    static int[][] arr;
    public static int minSumPath(int[][] grid) {
        arr = new int[grid.length][grid[0].length];
        for(int i = 0; i < arr.length; i++){
            Arrays.fill(arr[i], -1);
        }
//        return helper(grid.length-1, grid[0].length-1, grid);
        return helper2(grid.length, grid[0].length, grid);
    }

//    recursion -> memoization
    private static int helper(int r, int c, int[][] grid){
        if(r < 0 || c < 0)
            return -1;
        if(r == 0 && c == 0)
            return grid[0][0];
        if(arr[r][c] != -1)
            return arr[r][c];

        int top = helper(r-1,c, grid);
        int left = helper(r,c-1, grid);

        if(top == -1 && left == -1)
            return -1;
        if(top == -1)
            return arr[r][c] = grid[r][c]+left;
        if(left == -1)
            return arr[r][c] = grid[r][c]+ top;
        return arr[r][c] = grid[r][c] + Math.min(top, left);
    }

    private static int helper2(int r, int c, int[][] grid){
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(i == 0 && j == 0) {
                    arr[0][0] = grid[0][0];
                    continue;
                }

                int top = -1;
                int left = -1;

                if(i > 0)
                    top = arr[i-1][j];
                if(j > 0)
                    left = arr[i][j-1];

                if(top == -1)
                    arr[i][j] = grid[i][j] + left;
                else if(left == -1)
                    arr[i][j] = grid[i][j] + top;
                else arr[i][j] = grid[i][j] + Math.min(top, left);
            }
        }
        return arr[r-1][c-1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {5, 9, 6},
                {11, 5, 2}
        };
        System.out.println(minSumPath(grid));
    }
}
