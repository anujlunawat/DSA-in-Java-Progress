import java.util.Arrays;

public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
//        return helper(m-1, n-1);
        arr = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(arr[i], -1);
//        return helper2(m-1, n-1);
        return helper3(m, n);
    }

//    recursion
    private int helper(int m, int n){
        if(m < 0 || n < 0)
            return 0;
        if(m == 0 && n == 0)
            return 1;
        int up = helper(m-1, n);
        int left = helper(m, n-1);
        return up + left;
    }

//    memoization: top-down approach
    int[][] arr;
    private int helper2(int m, int n){
        if(m < 0 || n < 0)
            return 0;
        if(m == 0 && n == 0)
            return 1;
        if(arr[m][n] != -1)
            return arr[m][n];
        int up = helper2(m-1, n);
        int left = helper2(m, n-1);
        return arr[m][n] = up + left;
    }

//    tabulation: bottom-up approach
    private int helper3(int m, int n){
//        arr[0][0] = 1;

        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    arr[i][j] = 1;
                    continue;
                }
                int left = 0, up = 0;
                if(j > 0)
                    left += arr[i][j-1];
                if(i > 0)
                    up += arr[i-1][j];
                arr[i][j] = left + up;
            }
        }
        return arr[m-1][n-1];
    }

//    tabulation space optimization
    private int helper4(int m, int n){
        int[] top = new int[n];
        int[] curr = new int[n];

        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    curr[j] = 1;
                    continue;
                }
                int left = 0;
                if(j > 0)
                    left += curr[j-1];
                curr[j] = left + top[j];
            }

            top = curr;
            curr = new int[n];
        }
        return top[n-1];
    }
}
