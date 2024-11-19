public class NumOfDiceRollsWTargetSum1155 {
    public static void main(String[] args) {
        System.out.println(numRollsToTarget(30, 30, 500));
    }

    public static int numRollsToTarget(int n, int k, int target) {
        return (int)sol(n, k, target, 0);
    }

    private static long sol(int n, int k, int target, int sum){
        long count = 0;
        if(n <= 0){
            return (sum == target ? 1 : 0);
        }

        if(sum >= target)
            return 0;

        for(int i = 1; i <= k; i++){
            if(sum + i <= target){
                count += sol(n-1, k, target, sum + i);
                count %= ((long) Math.pow(10, 9) + 7);
//
//                if(count >= 200000000)
//                    System.out.println("HERE");
            }
        }

        return count;
    }
}
