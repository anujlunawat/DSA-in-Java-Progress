public class PathWMaxGold1219 {
    public static void main(String[] args) {
        int[][] maze = {
                {0,6,0},
                {0,8,7},
                {0,9,0}
        };

        int max = 0;
        int t;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if(maze[i][j] != 0) {
                    t = maxGold2(i, j, maze, 0);
                    max = Math.max(t, max);
                }
            }
        }
        System.out.println(max);
    }

    static int maxGold2(int r, int c, int[][] maze, int gold){

        if(maze[r][c] == 0)
            return maze[r][c];

        int value = maze[r][c];
        gold += value;
        maze[r][c] = 0;

        int i, j, k, l=k=j=i=0;
        if(r < maze.length - 1) {
            i = maxGold2(r + 1, c, maze, gold) ;
        }

        if(c < maze[0].length - 1) {
            j = maxGold2(r, c + 1, maze, gold);
        }
        if(r > 0) {
            k = maxGold2(r - 1, c, maze, gold);
        }

        if(c > 0) {
            l = maxGold2(r, c - 1, maze, gold);
        }
        maze[r][c] = value;
        int max = Math.max(Math.max(i, j), Math.max(k, l));
        return max + maze[r][c];
    }
}
