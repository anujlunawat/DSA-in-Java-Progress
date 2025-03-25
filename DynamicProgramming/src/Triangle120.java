import java.util.Arrays;
import java.util.List;

public class Triangle120 {
    public int minimumTotal(List<List<Integer>> triangle) {
//        return helper(0, 0, triangle);
        arr = new int[triangle.size()][];
        for(int i = 0; i < triangle.size(); i++){
            arr[i] = new int[triangle.get(i).size()];
            Arrays.fill(arr[i], -1);
        }
        return helper3(triangle);
    }

//    recursion
    private int helper(int r, int c, List<List<Integer>> triangle){
        if(r == triangle.size()-1 && c == triangle.get(r).size()-1)
            return triangle.get(r).get(c);

        Integer down = null, diagonal = null;
        if(r < triangle.size()-1) {
            down = helper(r + 1, c, triangle);
            diagonal = helper(r + 1, c + 1, triangle);
        }

        if(down == null)
            return triangle.get(r).get(c);
        return triangle.get(r).get(c) + Math.min(down, diagonal);
    }

//    memoization
    int[][] arr;
    private int helper2(int r, int c, List<List<Integer>> triangle){
        if(r == triangle.size()-1 && c == triangle.get(r).size()-1)
            return triangle.get(r).get(c);
        if(arr[r][c] != -1)
            return arr[r][c];

        Integer down = null, diagonal = null;
        if(r < triangle.size()-1) {
            down = helper2(r + 1, c, triangle);
            diagonal = helper2(r + 1, c + 1, triangle);
        }

        if(down == null)
            return triangle.get(r).get(c);
        return arr[r][c] = triangle.get(r).get(c) + Math.min(down, diagonal);
    }

//    tabulation
    private int helper3(List<List<Integer>> triangle){
        arr[0][0] = triangle.get(0).get(0);
        int min = arr[0][0];
        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){

                int upper_left_diagonal = Integer.MAX_VALUE, up = Integer.MAX_VALUE;
                if(j > 0)
                    upper_left_diagonal = arr[i-1][j-1];
                if(j < arr[i-1].length)
                    up = arr[i-1][j];

                arr[i][j] = triangle.get(i).get(j) + Math.min(up, upper_left_diagonal);
                if(i == arr.length-1)
                    min = Math.min(arr[i][j], min);
            }
        }
        return min;
    }
}
