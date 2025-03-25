import java.util.Arrays;

public class Fibonacci {

    // memoization
    static long[] dp;
    private static long fibonacci(int n){
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];

        dp[n] = fibonacci(n-1) + fibonacci(n-2);
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        dp = new long[n+1];
        Arrays.fill(dp, -1);

        System.out.println(fibonacci(n));

//        tabulation
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n]);


        int a = 0;
        int b = 1;

        for(int i = 2; i <= n; i++){
            int temp = a;
            a = b;
            b = temp + a;
        }

        System.out.println(b);
    }
}
