import java.util.Arrays;
import java.util.Stack;

public class NextGreaterEleI496 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();
        nextGreaterEleForEveryEle(nums2, ans, stack, ans.length - 1);
        return forReqEle(nums2, ans, nums1);
    }
    private static void nextGreaterEleForEveryEle(int[] nums, int[] ans, Stack<Integer> stack, int i){
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


        nextGreaterEleForEveryEle(nums, ans, stack, --i);
    }

    private static int[] forReqEle(int[] nums2, int[] ans, int[] nums1){
        int[] ans2 = new int[nums1.length];

        for(int i = 0; i < ans2.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums2[j] == nums1[i]){
                    ans2[i] = ans[j];
                }
            }
        }
        return ans2;
    }
}
