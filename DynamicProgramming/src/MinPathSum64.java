import java.util.Arrays;

public class MinPathSum64 {
    public int minPathSum(int[][] grid) {
        arr = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++)
            Arrays.fill(arr[i], -1);
        return helper2(0, 0, grid);
    }

//    recursion
    private int helper(int r, int c, int[][] grid){
        if(r > grid.length-1 || c > grid[0].length-1)
            return Integer.MAX_VALUE;
        if(r == grid.length-1 && c == grid[0].length-1)
            return grid[r][c];

        int down_sum = helper(r+1, c, grid);
        int right_sum = helper(r, c+1, grid);

        return grid[r][c] + Math.min(down_sum, right_sum);
    }

//    memoization
    int[][] arr;
    private int helper2(int r, int c, int[][] grid){
        if(r > grid.length-1 || c > grid[0].length-1)
            return Integer.MAX_VALUE;
        if(r == grid.length-1 && c == grid[0].length-1)
            return grid[r][c];
        if(arr[r][c] != -1)
            return arr[r][c];

        int down_sum = helper2(r+1, c, grid);
        int right_sum = helper2(r, c+1, grid);

        return arr[r][c] = grid[r][c] + Math.min(down_sum, right_sum);
    }

//    tabulation
    private int helper3(int[][] grid){
//        arr[0][0] = grid[0][0];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(i == 0 && j == 0) {
                    arr[0][0] = grid[0][0];
                    continue;
                }
                int left = Integer.MAX_VALUE, up = Integer.MAX_VALUE;
                if(j > 0)
                    left = arr[i][j-1];
                if(i > 0)
                    up = arr[i-1][j];
                arr[i][j] = grid[i][j] + Math.max(left, up);
            }
        }
        return arr[grid.length-1][ grid[0].length-1];
    }
}
