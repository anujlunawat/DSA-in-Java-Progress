public class FrogJump403 {
    public static boolean canCross(int[] stones) {
//        because it starts from the 1st index, and the initial jump is 1
        return helper(1, 1, stones);
    }

    private static boolean helper(int n, int ind, int[] stones){
        if(ind == stones.length - 1)
            return true;

        boolean result = false;
        for(int j = ind+1; j < stones.length; j++){
            for(int i = -1; i < 2; i++){
                if(stones[j] - stones[ind] == n+i)
                    result = helper(n+i, ind+j, stones);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        System.out.println(canCross(stones));
    }
}
