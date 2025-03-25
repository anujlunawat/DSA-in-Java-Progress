import java.util.Arrays;

public class FrogJumpCode360 {
    public static int frogJump(int n, int heights[]) {
        return helper(n-1, heights, 0);
    }


//    simple recursion
    private static int helper(int n, int[] heights, int curr){
        if(curr == n)
            return 0;
        if(curr > n)
            return -1;
        if(curr == n - 1)
            return Math.abs(heights[curr] - heights[curr + 1]);

        int energy1 = Math.abs(heights[curr] - heights[curr + 1]);
        energy1 += helper(n, heights, curr + 1);

        int energy2 = Math.abs(heights[curr] - heights[curr + 2]);
        energy2 += helper(n, heights, curr + 2);

        if(energy1 < energy2)
            return energy1;
        return energy2;
    }

//    memoization
    private static int helper(int n, int[] heights){
        if(n == 0)
            return 0;
        if(arr[n] != -1)
            return arr[n];

        int left = helper(n-1, heights) + Math.abs(heights[n-1] - heights[n]);
        int right = left + 1;
        if(n - 2 >= 0){
            right = helper(n-2, heights) + Math.abs(heights[n-2] - heights[n]);
        }

        arr[n] = Math.min(left, right);
        return arr[n];
    }

//    tabulation
    private static int helper2(int n, int[] heights){
        Arrays.fill(arr, -1);
        arr[0] = 0;

        for(int i = 1; i < n; i++){
            int one_jump = Math.abs(heights[i] - heights[i-1]) + arr[i-1];
            int two_jumps = i > 1 ? Math.abs(heights[i] - heights[i-2]) + arr[i-2] : one_jump + 1;

            arr[i] = Math.min(one_jump, two_jumps);
        }
        return arr[n-1];
    }

    private static int helper3(int n, int[] heights){
        Arrays.fill(arr, -1);
        for(int i = 0; i < n - 1; i++){
            int one_jump_forward = Math.abs(heights[i] - heights[i+1]);
            int two_jump_forward = i < n-2 ? Math.abs(heights[i] - heights[i+2]) : one_jump_forward + 1;

            arr[i] = Math.min(one_jump_forward, two_jump_forward);
        }

        int energy = 0;
        for(int i = 0; i < n - 1;){
            energy += arr[i];

            if(i + 2 > n - 1 || arr[i+1] < arr[i+2])
                i += 1;
            else
                i+=2;
        }
        return energy;
    }

    static int[] arr;
    public static void main(String[] args) {
        int[] heights = {7 ,4 ,4, 2, 6, 6, 3, 4 };
        arr = new int[heights.length];
        Arrays.fill(arr, -1);

        System.out.println(helper(heights.length-1, heights));
        System.out.println(frogJump(heights.length, heights));
        System.out.println(helper2(heights.length, heights));
        System.out.println(helper3(heights.length, heights));
    }
}
