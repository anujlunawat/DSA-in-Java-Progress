import java.util.Stack;

public class TrappingRainWater42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap2(height));
    }

    public static int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
//        int left_pillar_len = 0;

        for(int i = 0; i < height.length; i++){
            int len = height[i];

            if(stack.isEmpty()){
                stack.push(len);
                continue;
            }
            if(len >= stack.getFirst() || (i == height.length-1 && len != 0)){
//                left_pillar_len = len;
                int area = (stack.size() - 1) * Math.min(stack.getFirst(), len);
                while(stack.size() > 1)
                    area -= stack.pop();
                stack.pop();
                ans += area;
                stack.push(len);
            }
            else{
                stack.push(len);
            }
        }
        return ans;
    }

    public static int trap2(int[] height){
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        int[] prefixMax = new int[height.length];
        int[] suffixMax = new int[height.length];

        prefixMax[0] = height[0];
        for(int i = 1; i < height.length; i++)
            prefixMax[i] = Math.max(prefixMax[i-1], height[i]);

        suffixMax[suffixMax.length - 1] = height[height.length - 1];
        for(int i = suffixMax.length - 2; i >= 0; i--){
            suffixMax[i] = Math.max(suffixMax[i+1], height[i]);
        }

        for(int i = 0; i < height.length; i++){
            int len = height[i];
            int leftMax = prefixMax[i];
            int rightMax = suffixMax[i];

            if(len < leftMax && len < rightMax){
                ans += Math.min(leftMax, rightMax) - len;
            }
        }
        return ans;
    }
}
