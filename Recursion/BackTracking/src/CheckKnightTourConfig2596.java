import java.util.Arrays;

public class CheckKnightTourConfig2596 {

    public static void main(String[] args) {
        int[][] grid = {
            {0, 11, 16, 5, 20},
            {17, 4, 19, 10, 15},
            {12, 1, 8, 21, 6},
            {3, 18, 23, 14, 9},
            {24, 13, 2, 7, 22}
        };

        System.out.println(checkValidGrid(grid));
    }
    public static boolean checkValidGrid(int[][] grid) {
        return checkValidGrid(grid, 0, 0, 1);
    }
    private static boolean checkValidGrid(int[][] grid, int r, int c, int move){
        grid[r][c] = -1;
        if(move >= grid.length * grid.length)
            return true;
        System.out.println("move: " + move);
        int[] ans = check(grid, r, c, move);
        if(!Arrays.equals(ans, new int[]{-1, -1}))
            return checkValidGrid(grid, ans[0], ans[1], move + 1);
        return false;
    }

    private static int[] check(int[][] grid, int r, int c, int m){
//        go up
        if(r > 1){
            if(c > 0 && grid[r-2][c-1] != -1)
                return new int[]{r-2, c-1};
            if(c < grid.length - 1 && grid[r-2][c+1] != -1)
                return new int[]{r-2, c+1};
        }
//        go down
        if(r < grid.length - 2){
            if(c > 0 && grid[r+2][c-1] != -1)
                return new int[]{r+2, c-1};
            if(c < grid.length - 1 && grid[r+2][c+1] != -1)
                return new int[]{r+2, c+1};
        }

//        go left
        if(c > 1){
//            go up
            if(r > 0 && grid[r-1][c-2] != -1)
                return new int[]{r-1, c-2};
//            go down
            if(r < grid.length - 1 && grid[r+1][c-2] != -1)
                return new int[]{r+1, c-2};
        }

//        go right
        if(c < grid.length - 2){
//            go up
            if(r > 0 && grid[r-1][c+2] != -1)
                return new int[]{r-1, c+2};
//            go down
            if(r < grid.length - 1 && grid[r+1][c+2] != -1)
                return new int[]{r+1, c+2};
        }

        return new int[]{-1, -1};
    }
}
