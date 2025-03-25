public class CherryPickup741 {
    public static int cherryPickup(int[][] grid) {
        arr = new Integer[grid.length][grid.length][grid.length][grid.length];
        return Math.max(0, helper2(0, 0, 0,0, grid, grid.length-1));
    }

//    recursion
    private static int helper(int r1, int c1, int r2, int c2, int[][] grid, int n){
        if(r1 > n || c1 > n || r2 > n || c2 > n || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;
        if(r1 == n && c1 == n)
            return grid[r1][c1];
        if (r2 == 0 && c2 == 0)
            return grid[r1][c2];

        int max = Math.max(
        Math.max(helper(r1 + 1, c1, r2 + 1, c2, grid, n), helper(r1 + 1, c1, r2, c2 + 1,  grid, n)),
        Math.max(helper(r1, c1 + 1, r2 + 1, c2,  grid, n), helper( r1, c1 + 1, r2, c2 + 1,  grid, n)));

        if(r1 == r2 && c1 == c2 )
            return max + grid[r1][c1];
        return max + grid[r1][c1] + grid[r2][c2];
    }

//    memoization
    static Integer[][][][] arr;
    private static int helper2(int r1, int c1, int r2, int c2, int[][] grid, int n){
        if(r1 > n || c1 > n || r2 > n || c2 > n || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;
        if(r1 == n && c1 == n)
            return grid[r1][c1];
        if (r2 == n && c2 == n)
            return grid[r1][c2];
        if(arr[r1][c1][r2][c2] != null)
            return arr[r1][c1][r2][c2];

        int max;
        max = Math.max(
        Math.max(helper2(r1 + 1, c1, r2 + 1, c2, grid, n), helper2(r1 + 1, c1, r2, c2 + 1,  grid, n)),
        Math.max(helper2(r1, c1 + 1, r2 + 1, c2,  grid, n), helper2( r1, c1 + 1, r2, c2 + 1,  grid, n)));

        if(r1 == r2 && c1 == c2 )
            return arr[r1][c1][r2][c2] = max + grid[r1][c1];
        return arr[r1][c1][r2][c2] = max + grid[r1][c1] + grid[r2][c2];
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, -1},
            {1, 0, -1},
            {1, 1, 1}
        };


        System.out.println(cherryPickup(grid));
    }
}
