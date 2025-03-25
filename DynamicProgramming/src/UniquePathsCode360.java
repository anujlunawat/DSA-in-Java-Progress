import java.util.Arrays;

public class UniquePathsCode360 {
    static int[][] arr;
    public static int uniquePaths(int m, int n) {
        arr = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(arr[i], -1);

        return helper2(m-1, n-1);
    }
//    recursion
    private static int helper(int r, int c, int curr_r, int curr_c){
        if(curr_r >= r || curr_c >= c)
            return 0;

        if(curr_r == r-1 && curr_c == c-1)
            return 1;

        int down = helper(r, c, curr_r+1, curr_c);
        int right = helper(r, c, curr_r, curr_c+1);
        return down + right;
    }

//    memoization
    private static int helper2(int r, int c){
        if(r < 0 || c < 0)
            return 0;
        if(r == 0 && c == 0)
            return 1;
        if(arr[r][c] != -1)
            return arr[r][c];

        int up = helper2(r-1, c);
        int left = helper2(r, c-1);

        return arr[r][c] = up + left;
    }

//    tabulation
    private static int helper3(int r, int c){
        for(int i = 0; i < r; i++)
            Arrays.fill(arr[i], 0);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(i == 0 && j == 0){
                    arr[i][j] = 1;
                    continue;
                }
//                check for left
                if(i > 0)
                    arr[i][j] += arr[i-1][j];
//                check for up
                if(j > 0)
                    arr[i][j] += arr[i][j-1];
            }
        }
        return arr[r-1][c-1];
    }


    //    tabulation space optimization
    private static int helper4(int r, int c){
        if(r==1 && c == 1)
			return 1;
        int[] r1 = new int[c];
        int[] r2 = new int[c];
        r2[0] = 1;

//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
////                check for left
//                if(j > 0)
//                    r2[j] += r2[j-1];
////                check for up
//                r2[j] += r1[j];
//            }
////            r1 = r2.clone();
//            r1 = r2;
//            r2 = new int[c];
//        }

        for(int i = 0; i < r*c; i++){
            int j = i % c;
//            check for left
            if(j > 0)
                r2[j] += r2[j-1];
//          check for up
            r2[j] += r1[j];

            if((i+1) % c == 0 && i != 0){
                r1 = r2;
                r2 = new int[c];
            }
        }
        return r1[c-1];
    }


    public static void main(String[] args) {
        int m = 3, n=3;
        System.out.println(uniquePaths(m,n));
        System.out.println(helper3(m, n));
        System.out.println(helper4(m, n));
//        for(int[] x: arr){
//            System.out.println(Arrays.toString(x));
//        }

    }
}
