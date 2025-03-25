import java.util.Arrays;

public class MinPathSumVarEndingPointsCode360 {
    static int[][] arr;
    public static int minimumPathSum(int[][] triangle, int n) {
        arr = new int[n][];
        for(int i = 0; i < n; i++){
            arr[i] = new int[i+1];
            Arrays.fill(arr[i], -1);;
        }

//        int min = Integer.MAX_VALUE;
//        for(int i = 0; i < triangle[n-1].length; i++)
//            min = Math.min(helper(n-1, i, triangle), min);

        return helper2(triangle);

//        return min;
    }

//    recursion -> memoization
    private static int helper(int r, int c, int[][] triangle){
        if(r < 0 || c < 0 || c > triangle[r].length-1)
            return Integer.MAX_VALUE;
        if(r == 0)
            return triangle[r][c];
        if(arr[r][c] != -1)
            return arr[r][c];

        int min = Integer.MAX_VALUE;

//      go top
        int top = helper(r-1, c, triangle);
//      go top & left
        int topnleft = helper(r-1, c-1, triangle);

        min = Math.min(min, Math.min(top, topnleft) + triangle[r][c]);
        return arr[r][c] = min;
    }

//    tabulation
    static int helper2(int[][] triangle){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < triangle.length; i++){
            min = Integer.MAX_VALUE;
            for(int j = 0; j < i + 1; j++) {
                if (i == 0) {
                    arr[0][0] = triangle[0][0];
                    min = arr[0][0];
                    continue;
                }
                int top = Integer.MAX_VALUE;
                int topnleft = Integer.MAX_VALUE;
                if (j < arr[i - 1].length)
                    top = arr[i - 1][j];
                if (j > 0)
                    topnleft = arr[i - 1][j - 1];

                arr[i][j] = Math.min(top, topnleft) + triangle[i][j];
                min = Math.min(min, arr[i][j]);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] triangle = {
            {-10},
        };

        System.out.println(minimumPathSum(triangle, triangle.length));
    }
}
