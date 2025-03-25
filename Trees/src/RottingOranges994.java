// No recursion
// BFS

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges994 {

    static int rottenOranges = 0;
    public static int orangesRotting(int[][] grid) {
    //    top, bottom, left, right
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, +1};

        Queue<int[]> ans = new LinkedList<>();
        int fresh_oranges = freshOranges(grid, ans);

        if(fresh_oranges == 0){
            return 0;
        }
        if(rottenOranges == 0)
            return -1;

        int time = 0;
        while(!ans.isEmpty()){
            time++;
            int size = ans.size();

            for(int j = 0; j < size; j++){
                int[] currentCell = ans.poll();
                int r = currentCell[0];
                int c = currentCell[1];

                for(int i = 0; i < dRow.length; i++){
                    if(conditions(grid, r + dRow[i], c + dCol[i])){
                        grid[r + dRow[i]][c + dCol[i]] = -1;
                        ans.offer(new int[]{r + dRow[i], c + dCol[i]});
                        fresh_oranges--;
                    }
                }
            }
        }
        if(fresh_oranges == 0)
            return time - 1;

        return -1;
    }

    private static int freshOranges(int[][] grid, Queue<int[]> ans){
        int a = 0;

        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1)
                    a++;
                if(grid[i][j] == 2) {
                    rottenOranges++;
                    grid[i][j] = -1;
                    ans.offer(new int[]{i, j});
                }
            }
        }
        return a;
    }

    private static boolean conditions(int[][] grid, int r, int c){
        if(!(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length))
            return false;

        return grid[r][c] != -1 && grid[r][c] != 0;
    }

    public static void main(String[] args) {
        int[][] grid = {
    {2, 1, 1},
    {1, 1, 1},
    {0, 1, 2}
};

        System.out.println(orangesRotting(grid));
    }
}
