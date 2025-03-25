import java.util.ArrayList;
import java.util.Arrays;

public class UniquePathsII360 {
    static long[][] arr;
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
            arr = new long[n][m];
            float mod = (float) (1e9 + 7);

            for(int i = 0; i < n; i++){
                Arrays.fill(arr[i], -1);
            }

            return (int)(helper(n-1, m-1, mat) % mod);
        }

//    memoization
    static long helper(int n, int m, ArrayList<ArrayList<Integer>> mat){
        if(n < 0 || m < 0)
            return 0;
        if(n == 0 && m == 0)
            return 1;
        if(mat.get(n).get(m) == -1)
            return 0;
        if(arr[n][m] != -1)
            return arr[n][m];

//        go down
        long down = helper(n-1, m, mat);
//        go left
        long left = helper(n, m-1, mat);
        return arr[n][m] = left + down;
    }

//    tabulation
    static long helper2(int n, int m, ArrayList<ArrayList<Integer>> mat){
        for(int i = 0; i < n; i++){
            Arrays.fill(arr[i], 0);
        }
        arr[0][0] = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat.get(i).get(j) == -1)
                    continue;
//                go up
                if(i > 0)
                    arr[i][j] += arr[i-1][j];
//                go left
                if(j > 0)
                    arr[i][j] += arr[i][j-1];
            }
        }
        return arr[n-1][m-1];
    }

    static int helper3(int n, int m, int[][] mat){
        int[] r1 = new int[m];
        int[] r2 = mat[0].clone();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1)
                    continue;
                if(i == 0 && j == 0){
                    r2[j] = 1;
                    continue;
                }
//                go left
                if(j > 0 && mat[i][j-1] != 1)
                    r2[j] += r2[j-1];
//                go up
                if(i > 0 && mat[i-1][j] != 1){
                    r2[j] += r1[j];
                }
            }
            r1 = r2;
            r2 = new int[m];
        }
        return r1[m-1];
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

        mat.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        mat.add(new ArrayList<>(Arrays.asList(0, -1, 0)));
        mat.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

        int[][] mat2 = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        System.out.println(mazeObstacles(3, 3, mat));
        System.out.println(helper3(3, 3, mat2));
//        System.out.println(helper2(3, 3, mat));
//        for(var x: arr){
//            System.out.println(Arrays.toString(x));
//        }
    }
}
