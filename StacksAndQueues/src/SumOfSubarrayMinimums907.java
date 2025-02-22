import java.util.Arrays;
import java.util.Stack;

public class SumOfSubarrayMinimums907 {
    public static void main(String[] args) {
        System.out.println(sumSubarrayMins3(new int[]{11,81,94,43,3}));
//        System.out.println(Arrays.toString(NSE(new int[]{11,81,94,43,3})));
    }

    public static int sumSubarrayMins(int[] arr) {
        int ans = 0;
        int mod = (int) 1e9 + 7;

        for(int i = 0; i < arr.length; i++){
            int min = arr[i];
            for(int j = i; j < arr.length; j++){
                min = Math.min(min, arr[j]);
                ans = (ans + min) % mod;
            }
        }
        return ans;
    }

    public static int sumSubarrayMins2(int[] arr){
        int ans = 0;
        int mod = (int) 1e9 + 7;

        for(int i = 0; i < arr.length; i++){
            int t = sumOfSubarrays(arr, i);
            ans = (ans + t * arr[i]) % mod;
        }

        return ans;
    }

    private static int sumOfSubarrays(int[] arr, int i){
        int left = 1;
        int right = 1;

        int j = i - 1;
        while(j >= 0 && arr[j--] > arr[i]){
            left++;
        }

        j = i + 1;
        while(j < arr.length && arr[j++] >= arr[i]){
            right++;
        }
        return left*right;
    }

    public static int sumSubarrayMins3(int[] arr){
        int[] nse = NSE(arr);
        int[] psee = PSEE(arr);
        int ans = 0;
        int mod = (int) 1e9 + 7;

//        System.out.println(Arrays.toString(nse));
//        System.out.println(Arrays.toString(psee));

        for(int i = 0; i < arr.length; i++){
            int left = i - psee[i];
            int right = nse[i] - i;

            ans = (ans + (left * right * arr[i]) % mod) % mod;
        }
        return ans;
    }

    private static int[] NSE(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[arr.length];

        for(int i = arr.length - 1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();

            nse[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }

        return nse;
    }

    private static int[] PSEE(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] psee = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i])
                st.pop();

            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return psee;
    }
}
