import java.util.Arrays;

public class FrogJumpWithKDistCode360 {

    private static int[] arr;
    public static int minimizeCost(int n, int k, int []height){
        arr = new int[height.length];
        Arrays.fill(arr, -1);
        return helper(n-1, k, height);
    }

//    memoization
    private static int helper(int n, int k, int[] height){
        if(n == 0)
            return 0;
        if(arr[n] != -1) return arr[n];

        int energy = Integer.MAX_VALUE;
        for(int i = 1; i <= k && n-i >= 0; i++){
            int temp = helper(n-i, k, height) + Math.abs(height[n-i] - height[n]);
            energy = Math.min(temp, energy);
        }
        arr[n] = energy;
        return energy;
    }

//    tabulation
     private static int helper2(int n, int k, int[] height){
         Arrays.fill(arr, -1);
         arr[0] = 0;

         int min = 0;
         for(int i = 1; i < n; i++){
             min = Integer.MAX_VALUE;
             for(int j = 1; j <= k && i-j >= 0; j++){
                 int energy = Math.abs(height[i] - height[i-j]) + arr[i-j];
                 min = Math.min(energy, min);
             }
             arr[i] = min;
         }

         return arr[n-1];
     }

    public static void main(String[] args) {
        int[] height = {10,40,30,10};
        int k = 2;
        System.out.println(minimizeCost(height.length, k, height));
        System.out.println(helper2(height.length, k, height));
    }
}
