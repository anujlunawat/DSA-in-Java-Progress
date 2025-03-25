import java.util.Arrays;

public class CoinChange322 {
    public static int coinChange(int[] coins, int amount) {
//        Arrays.sort(coins);
        return helper(coins.length-1, amount, coins);
    }
    private static int helper(int i, int amount, int[] coins){
          if(amount == 0)
              return 0;
          if(i < 0)
              return -1;

          int total = amount / coins[i];
          int t = helper(i-1, amount%coins[i], coins);

          if(t == -1)
              return -1;
          return total + t;
    }

    public static void main(String[] args) {
        int[] coins = {1};
        System.out.println(coinChange(coins, 0));
    }
}
