//  https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1},
        };
        if(mat[0][0] == 0){
            System.out.println("No paths");
//            return new ArrayList<>();
        }

        System.out.println(paths(mat, 0, 0, ""));
    }
    static ArrayList<String> paths(int[][] mat, int r, int c, String path) {
        if(r >= mat.length - 1 && c >= mat.length - 1){
            ArrayList<String> t = new ArrayList<>();
            t.add(path);
            return t;
        }

        ArrayList<String> t = new ArrayList<>();

//        UP
        if(r > 0 && isSafe(mat, r-1, c)){
            mat[r][c] = 0;
            t.addAll(paths(mat, r-1, c, path+"U"));
            mat[r][c] = 1;
        }

//        DOWN
        if(r < mat.length-1 && isSafe(mat, r+1, c)){
            mat[r][c] = 0;
            t.addAll(paths(mat, r+1, c, path+"D"));
            mat[r][c] = 1;
        }

//        LEFT
        if(c > 0 && isSafe(mat, r, c-1)){
            mat[r][c] = 0;
            t.addAll(paths(mat, r, c-1, path+"L"));
            mat[r][c] = 1;
        }

//        RIGHT
        if(c < mat.length-1 && isSafe(mat, r, c+1)){
            mat[r][c] = 0;
            t.addAll(paths(mat, r, c+1, path+"R"));
            mat[r][c] = 1;
        }

        return t;
    }

    static boolean isSafe(int[][] mat, int r, int c){
        return mat[r][c] == 1;
    }
}
