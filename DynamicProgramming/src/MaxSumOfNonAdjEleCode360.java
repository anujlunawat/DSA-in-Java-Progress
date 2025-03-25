import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumOfNonAdjEleCode360 {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
//        return helper(0, nums);
//        arr = new int[nums.size()];
//        Arrays.fill(arr, -1);
//        arr[0] = nums.getFirst();
//        return helper2(nums.size()-1, nums);

//        return helper3(nums.size(), nums);
        return helper4(nums.size(), nums);
	}

    private static int helper(int n, ArrayList<Integer> nums){
        if(n >= nums.size())
            return 0;
        int left = helper(n+2, nums);
        int right = helper(n+1, nums);

        return Math.max(left + nums.get(n), right);
    }

//    memoization
    static int[] arr;
    private static int helper2(int n, ArrayList<Integer> nums){
        if(n < 0)
            return 0;
        if(arr[n] != -1)
            return arr[n];

//        when you are taking the value
        int left = helper2(n-2, nums);
//        when you are not taking the value
        int right = helper2(n-1, nums);

        arr[n] = Math.max(left + nums.get(n), right);
        return arr[n];
    }

//    tabulation
    private static int helper3(int n, ArrayList<Integer> nums){
        int[] arr = new int[nums.size()];
        arr[0] = nums.get(0);
        arr[1] = Math.max(arr[0], nums.get(1));

        for(int i = 2; i < nums.size(); i++){
            int take = nums.get(i) + arr[i - 2];
            int skip = arr[i-1];

            arr[i] = Math.max(take, skip);
        }
        return arr[arr.length-1];
    }

//    space optimization
    private static int helper4(int n, ArrayList<Integer> nums){
        int a = nums.get(0);
        int b = Math.max(a, nums.get(1));

        for(int i = 2; i < nums.size(); i++){
            int temp = b;

            int take = nums.get(i) + a;
            b = Math.max(take, b);
            a = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(1);
        numbers.add(4);
        numbers.add(9);
//        numbers.add(5);
//        numbers.add(8);
//        numbers.add(1);
//        numbers.add(9);

//        System.out.println(maximumNonAdjacentSum(numbers));
        System.out.println(maximumNonAdjacentSum(numbers));
    }
}
