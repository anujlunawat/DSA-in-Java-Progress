import java.util.Arrays;

public class NinjasTrainingCode360 {

    static int[][] arr;
    public static int ninjaTraining(int n, int[][] points) {
        arr = new int[points.length][points[0].length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = new int[]{-1, -1, -1};
        }

//        return helper(n-1, points, -1);
        return helper2(n-1, points, -1);
//        return helper3(n, points);
//        return helper4(n, points);
    }

//    recursion
    private static int helper(int n, int[][] points, int prev_task){
        int max = 0;
        if(n == 0){
            for(int i = 0; i < points[0].length; i++){
                if(i != prev_task)
                    max = Math.max(max, points[n][i]);
            }
            return max;
        }

        for(int i = 0; i < points[0].length; i++){
                if(i != prev_task){
                    int p = points[n][i] + helper(n-1, points, i);
                    max = Math.max(max, p);
                }
        }
        return max;
    }

//    memoization
    private static int helper2(int n, int[][]points, int prev_task){
        int max = 0;
        if(n < 0)
            return 0;
        if(n == 0){
            for(int i = 0; i < points[0].length; i++){
                if(i != prev_task)
                    max = Math.max(max, points[n][i]);
            }
            return max;
        }

        if(prev_task != -1 && arr[n][prev_task] != -1) return arr[n][prev_task];

        for(int i = 0; i < points[0].length; i++){
            if(i != prev_task){
                int p = points[n][i] + helper2(n-1, points, i);
                max = Math.max(max, p);
            }
        }
        return prev_task != -1 ? arr[n][prev_task] = max : max;
    }

//    tabulation
    static int helper3(int n, int[][] points){
        arr[0] = points[0];
        int max = 0;

        for(int i = 1; i < n; i++){
            max = 0;
            for (int j = 0; j < points[0].length; j++) {
                int maxi = 0;
//                finding max value with each value of previous row
                for(int k = 0; k < points[0].length; k++){
                    if(k != j){
                        maxi = Math.max(maxi, arr[i-1][k]);
                    }
                }
                arr[i][j] = maxi + points[i][j];
                max = Math.max(arr[i][j], max);
            }
        }
        return max;
    }

//    tabulation space optimization
    static int helper4(int n, int[][] points){
        int[] prev = points[0];
        int[] current = new int[]{-1, -1, -1};
        int max = 0;

        for(int i = 1; i < n; i++){
            max = 0;
            for (int j = 0; j < points[0].length; j++) {
                int maxi = 0;
//                finding max value with each value of previous row
                for(int k = 0; k < points[0].length; k++){
                    if(k != j){
                        maxi = Math.max(maxi, prev[k]);
                    }
                }
                current[j] = maxi + points[i][j];
                max = Math.max(current[j], max);
            }
            prev = current.clone();
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] points = {
            {1, 2, 5},
            {3, 1, 1},
            {3, 3, 3}
        };

        System.out.println(ninjaTraining(points.length, points));
//        for(var x: arr){
//            for(int i: x){
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
    }
}
