import java.util.Arrays;
import java.util.Stack;

public class NextGreaterEleII503 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
    public static int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        nextGreaterEleForEveryEle1(nums, ans, stack, ans.length - 1);
        nextGreaterEleForEveryEle2(nums, ans, stack);
        return ans;
    }
    private static void nextGreaterEleForEveryEle1(int[] nums, int[] ans, Stack<Integer> stack, int i){
        if(i < 0)
            return;

        while (!stack.isEmpty() && stack.peek() <= nums[i]) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            ans[i] = -1;
        } else {
            ans[i] = stack.peek();
        }
        stack.push(nums[i]);


        nextGreaterEleForEveryEle1(nums, ans, stack, --i);
    }

    private static void nextGreaterEleForEveryEle2(int[] nums, int[] ans, Stack<Integer> stack){
        for(int i = nums.length - 1; i >= 0; i--){
            if(ans[i] != -1 && nums[i] < -1)
                continue;
            while(!stack.isEmpty() && nums[i] >= stack.peek())
                stack.pop();
            if(!stack.isEmpty()){
                ans[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
    }

}
