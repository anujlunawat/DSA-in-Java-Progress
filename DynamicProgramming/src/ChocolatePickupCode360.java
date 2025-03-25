import java.util.Arrays;

public class ChocolatePickupCode360 {
    public static int maximumChocolates(int r, int c, int[][] grid) {
        arr = new int[c][r][c];
        for(int i = 0; i < c; i++){
            for(int j = 0; j < r; j++){
                Arrays.fill(arr[i][j], -1);
            }
        }
        return helper2(0, 0, c-1, grid);
	}
// recursion
    private static int helper(int r, int c1, int c2, int[][] grid){
        if(c1 > grid[0].length-1 || c1 < 0 || c2 > grid[0].length-1 || c2 < 0)
            return 0;
        if(r == grid.length-1){
            if(c1 == c2)
                return grid[r][c1];
            return grid[r][c1] + grid[r][c2];
        }

        int max = Integer.MIN_VALUE;
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                max = Math.max(max, helper(r+1, c1+i, c2+j, grid));
            }
        }
        if(c1 == c2)
            return max + grid[r][c1];
        return max + grid[r][c1] + grid[r][c2];
    }

//    memoization
    static int[][][] arr;
    private static int helper2(int r, int c1, int c2, int[][] grid){
        if(c1 > grid[0].length-1 || c1 < 0 || c2 > grid[0].length-1 || c2 < 0)
            return 0;
        if(r == grid.length-1){
            if(c1 == c2)
                return grid[r][c1];
            return grid[r][c1] + grid[r][c2];
        }
        if(arr[c1][r][c2] != -1)
            return arr[c1][r][c2];

        int max = Integer.MIN_VALUE;
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                max = Math.max(max, helper2(r+1, c1+i, c2+j, grid));
            }
        }
        if(c1 == c2)
            return arr[c1][r][c2] = max + grid[r][c1];
        return arr[c1][r][c2] = max + grid[r][c1] + grid[r][c2];
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 3, 1, 2},
            {3, 4, 2, 2},
            {5, 6, 3, 5}
        };
        System.out.println(maximumChocolates(grid.length, grid[0].length, grid));
    }
}
