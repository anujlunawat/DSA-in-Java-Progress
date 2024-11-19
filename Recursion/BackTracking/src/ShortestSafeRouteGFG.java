public class ShortestSafeRouteGFG {
    static int shortestSteps = -1;
    public static void main(String[] args) {
        int[][] mat = {
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,1,0,1,1},
                {1,1,1,1,1},
                {1,1,1,1,0},
        };
        for(int i = 0; i < mat.length; i++)
            shortestPath(mat, i, 0, 1);
        System.out.println(shortestSteps);
    }
    private static void shortestPath(int[][] mat, int r, int c, int steps){
        if(c == mat[0].length - 1){
            if(shortestSteps == -1 || shortestSteps > steps)
                shortestSteps = steps;

//            System.out.println("Steps: " + steps);
            return;
        }
        if(!condition(mat, r, c)){
            return;
        }
        if(mat[r][c] == -1)
            return;

        mat[r][c] = -1;

//        go up
        if(r > 0){
            shortestPath(mat, r - 1, c, steps + 1);
        }
//        go down
        if(r < mat.length - 1){
            shortestPath(mat, r + 1, c, steps + 1);
        }
//        go left
        if(c > 0){
            shortestPath(mat, r, c - 1, steps + 1);
        }
//        go right
        if(c < mat[0].length - 1){
            shortestPath(mat, r, c + 1, steps + 1);
        }
//        to change the starting column
//        if(c == 0){
//            shortestPath(mat, r + 1, c, steps);
//        }

        mat[r][c] = 1;
    }

    private static boolean condition(int[][] mat, int r, int c){
//        if mine is at same position
        if(mat[r][c] == 0)
            return false;
//        check if mine is at top
        if(r > 0 && mat[r - 1][c] == 0)
            return false;
//        check if mine is at bottom
        if(r < mat.length - 1 && mat[r + 1][c] == 0)
            return false;
//        check if mine is at left
        if(c > 0 && mat[r][c - 1] == 0)
            return false;
//        check if mine is at right
        if(c < mat[0].length - 1 && mat[r][c + 1] == 0)
            return false;
//        the cell position is safe
        return true;
    }
}
