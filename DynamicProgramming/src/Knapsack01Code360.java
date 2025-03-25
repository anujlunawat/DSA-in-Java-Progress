import java.util.Arrays;

public class Knapsack01Code360 {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        arr = new int[n][maxWeight+1];
//        for(int[] x: arr)
//            Arrays.fill(x, -1);
//        return helper2(n-1, maxWeight, weight, value);
//        return helper3(weight, value, maxWeight);
//        return helper4(weight, value, maxWeight);
        return helper5(weight, value, maxWeight);
    }

//    recursion
    private static int helper(int i, int maxWeight, int[] weight, int[] value){
        if(i < 0 || maxWeight == 0)
            return 0;

        int skip = helper(i-1, maxWeight, weight, value);
        int take = 0;
        if(weight[i] <= maxWeight)
            take = value[i] + helper(i-1, maxWeight - weight[i], weight, value);

        return Math.max(skip, take);
    }
    //    memoization
    static int[][] arr;
    private static int helper2(int i, int maxWeight, int[] weight, int[] value){
        if(i < 0 || maxWeight == 0)
            return 0;
        if(arr[i][maxWeight] != -1)
            return arr[i][maxWeight];

        int skip = helper2(i-1, maxWeight, weight, value);
        int take = 0;
        if(weight[i] <= maxWeight)
            take = value[i] + helper2(i-1, maxWeight - weight[i], weight, value);

        return arr[i][maxWeight] = Math.max(skip, take);
    }

//    tabulation
    private static int helper3(int[] weight, int[] value, int maxWeight){
        Arrays.fill(arr[0], 0);
        for(int i = weight[0]; i <= maxWeight; i++)
            arr[0][i] = value[0];

        for(int i = 1; i < weight.length; i++){
            for(int w = 0; w <= maxWeight; w++){
                int skip = arr[i-1][w];
                int take = 0;
                if(w >= weight[i])
                    take = value[i] + arr[i-1][w-weight[i]];

                arr[i][w] = Math.max(skip, take);
            }
        }
        return arr[weight.length-1][maxWeight];
    }

//    tabulation space optimization
    private static int helper4(int[] weight, int[] value, int maxWeight){
        int[] prev = new int[maxWeight+1];
        int[] curr = new int[maxWeight+1];

        Arrays.fill(prev, 0);
        for(int i = weight[0]; i <= maxWeight; i++)
            prev[i] = value[0];

        for(int i = 1; i < weight.length; i++){
            for(int w = 0; w <= maxWeight; w++){
                int skip = prev[w];
                int take = 0;
                if(w >= weight[i])
                    take = value[i] + prev[w-weight[i]];

                curr[w] = Math.max(skip, take);
            }
            prev = curr;
            curr = new int[maxWeight+1];
        }
        return prev[maxWeight];
    }

//    tabulation space optimization++
    private static int helper5(int[] weight, int[] value, int maxWeight){
        int[] prev = new int[maxWeight+1];

        Arrays.fill(prev, 0);
        for(int i = weight[0]; i <= maxWeight; i++)
            prev[i] = value[0];

        for(int i = 1; i < weight.length; i++){
            for(int w = maxWeight; w >= weight[i]; w--) {
                prev[w] = Math.max(prev[w], value[i] + prev[w - weight[i]]);
            }
        }
        return prev[maxWeight];
    }

    public static void main(String[] args) {
        int[] weight = {1,2,4,5};
        int[] value = {5,4,8,6};
        System.out.println(knapsack(weight, value, weight.length, 5));

    }
}
