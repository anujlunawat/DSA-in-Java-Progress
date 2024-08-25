import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };

        int[][] path = new int[maze.length][maze[0].length];
        mazePath2(0, 0, maze, path, 1);

//        path(0, 0, "", maze);
//        System.out.println(countPaths(3, 3));
//        path(3, 3, "");
//        pathWithDiag(3, 3, "");
//        System.out.println();
//        pathWithDiagAndObstacle(3, 3, "", new int[]{2,2});
    }

    static int countPaths(int r, int c){
        if(r == 1 || c == 1)
            return 1;

       return countPaths(r-1, c) + countPaths(r, c-1);

    }

    static void path(int r, int c, String path){
        if(r == 1 && c == 1) {
            System.out.println(path);
            return;
        }

        if(r > 1)
            path(r-1, c, path+"D");

        if(c > 1)
            path(r, c-1, path+"R");

    }

    static void pathWithDiag(int r, int c, String path){
        if(r == 1 && c == 1) {
            System.out.println(path);
            return;
        }

        if(r > 1)
            pathWithDiag(r-1, c, path+"D");

        if(c > 1)
            pathWithDiag(r, c-1, path+"R");

        if(c > 1 && r > 1)
            pathWithDiag(r-1, c-1, path+"d");

    }

    static void pathWithDiagAndObstacle(int r, int c, String path, int[] river){
        if(r == river[0] && c == river[1])
            return;

        if(r == 1 && c == 1) {
            System.out.println(path);
            return;
        }


        if(r > 1)
            pathWithDiagAndObstacle(r-1, c, path+"D", river);

        if(c > 1)
            pathWithDiagAndObstacle(r, c-1, path+"R", river);

        if(c > 1 && r > 1)
            pathWithDiagAndObstacle(r-1, c-1, path+"d", river);

    }

    static void path(int r, int c, String path, boolean[][] maze){
        if(r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(path);
            return;
        }

        if(!maze[r][c])
            return;

        maze[r][c] = false;

        if(r < maze.length - 1) {
            path(r + 1, c, path + "D", maze);
        }

        if(c < maze[0].length - 1) {
            path(r, c + 1, path + "R", maze);
        }
        if(r > 0) {
            path(r - 1, c, path + "U", maze);
        }

        if(c > 0) {
            path(r, c - 1, path + "L", maze);
        }
        maze[r][c] = true;
    }

    static void mazePath(int r, int c, String path, boolean[][] maze){
        if(r == maze.length - 1 && c == maze[0].length - 1) {
            maze[r][c] = false;
            System.out.println();

            int i = 1;
            System.out.println("---------");
            for(boolean[] x: maze){
                for(boolean y: x) {
                    if(!y)
                        System.out.print("|"+i++ +" ");
                    else
                        System.out.print("|  ");
                }
                System.out.println("\n---------");
            }

            maze[r][c] = true;
            return;
        }

        if(!maze[r][c])
            return;

        maze[r][c] = false;

        if(r < maze.length - 1) {
            mazePath(r + 1, c, path + "D", maze);
        }

        if(c < maze[0].length - 1) {
            mazePath(r, c + 1, path + "R", maze);
        }
        if(r > 0) {
            mazePath(r - 1, c, path + "U", maze);
        }

        if(c > 0) {
            mazePath(r, c - 1, path + "L", maze);
        }
        maze[r][c] = true;
    }
    static void mazePath2(int r, int c, boolean[][] maze, int[][] path, int count){
        if(r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = count;
            System.out.println();

            for(int[] x: path){
                System.out.println(Arrays.toString(x));
            }
            System.out.println();

            return;
        }

        if(!maze[r][c])
            return;

        maze[r][c] = false;
        path[r][c] = count;

        if(r < maze.length - 1) {
            mazePath2(r + 1, c, maze, path, count+1);
        }

        if(c < maze[0].length - 1) {
            mazePath2(r, c + 1, maze, path, count+1);
        }
        if(r > 0) {
            mazePath2(r - 1, c, maze, path, count+1);
        }

        if(c > 0) {
            mazePath2(r, c - 1, maze, path, count+1);
        }
        maze[r][c] = true;
        path[r][c] = 0;
    }

}