import java.util.ArrayList;

public class RatInAMazeGFG {
    public static void main(String[] args) {

    }

    private static ArrayList<String> paths(int[][] mat, int r, int c, String p){
        ArrayList<String> ans = new ArrayList<>();
        if(mat[r][c] == 0){
            return ans;
        }
        if (r == mat.length - 1 && c == mat.length - 1) {
            ans.add(p);
            return ans;
        }

        mat[r][c] = 0;

//        go down
        if(r < mat.length - 1)
            ans.addAll(paths(mat, r + 1, c, p + "D"));
//        go up
        if(r > 0)
            ans.addAll(paths(mat, r - 1, c, p + "U"));
//        go left
        if(c > 0)
            ans.addAll(paths(mat, r, c - 1, p + "L"));
//        go right
        if(c < mat.length - 1)
            ans.addAll(paths(mat, r, c + 1, p + "R"));

        mat[r][c] = 1;

        return ans;

    }
}
