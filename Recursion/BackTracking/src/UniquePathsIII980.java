public class UniquePathsIII980 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2},
        };

//        int[][] grid = {
//                {0, 1},
//                {2, 0}
//        };

        int startr = -1, startc = -1;
        int obstacles = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    startr = i;
                    startc = j;
                }
                else if(grid[i][j] == -1)
                    obstacles++;
            }
        }


        System.out.println(uniquePaths(grid, startr, startc, 1, obstacles));
    }

    private static int uniquePaths(int[][] grid, int r, int c, int steps, int obs){
        int totalPaths = 0;
        if(grid[r][c] == 2){
            if((grid.length * grid[0].length) - obs == steps){
                return 1;
            }
            return 0;
        }

        if(grid[r][c] == -1)
            return 0;

        grid[r][c] = -1;

//        go down
        if(r < grid.length - 1){
            totalPaths += uniquePaths(grid, r + 1, c, steps+1, obs);
        }
//        go up
        if(r > 0){
            totalPaths += uniquePaths(grid, r - 1, c, steps+1, obs);
        }
//        go left
        if(c > 0){
            totalPaths += uniquePaths(grid, r, c - 1, steps+1, obs);
        }
//        go right
        if(c < grid[r].length - 1){
            totalPaths += uniquePaths(grid, r, c + 1, steps+1, obs);
        }

        grid[r][c] = 0;

        return totalPaths;

    }
}
