import java.util.Stack;

public class LargestRectInHistogram84 {
    public static void main(String[] args) {
        int[] heights = {5,5,1,7,1,1,5,2,7,6};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
//        this is going to store all the values from a particular rectangle.
//        then we empty this for storing area values of next rectangles
        Stack<Integer> localStack = new Stack<>();
        localStack.push(0);
//        this stores the max values of each rectangle
        Stack<Integer> doneNums = new Stack<>();

//        for(int i = 0; i < heights.length; i++){
////            int maxArea = Integer.MIN_VALUE;
//            if(heights[i] == 0)
//                continue;
//
//            largestArea(heights, heights[i], 1, localStack, i);
//
//            do {
//                int t = localStack.pop();
//                if(t > maxArea)
//                    maxArea = t;
//                }while(!localStack.isEmpty());
//
//            finalStack.push(maxArea);
//            }
//
//        int finalMaxArea = Integer.MIN_VALUE;
//        while(!finalStack.isEmpty()){
//            int t = finalStack.pop();
//            finalMaxArea = Integer.max(finalMaxArea, t);
//        }
//        return finalMaxArea;

        for(int i = 0; i < heights.length; i++){
            if(!doneNums.isEmpty() && heights[i] < doneNums.peek()){
                doneNums.clear();
            }
            if(!doneNums.isEmpty() && doneNums.contains(heights[i])){
                continue;
            }
            if(heights[i] == 0){
                continue;
            }

            largestArea(heights, heights[i], 1, localStack, i);
            doneNums.push(heights[i]);
        }
        return localStack.peek();
    }

//    private static void largestArea(int[] heights, int l, int b, Stack<Integer> ans, int ind){
//        while(ind < heights.length - 1 && heights[ind] <= heights[ind+1]){
//            b++;
//            ind++;
//        }
//        ans.push(l * b);
//        if(ind >= heights.length - 1)
//            return;
////        System.out.println(heights[b]);
//        largestArea(heights, Math.min(heights[ind+1], l), b + 1, ans, ind+1);
//    }
//    private static void largestArea(int[] heights, int l, int b, Stack<Integer> ans, int ind) {
//
//
//         while(ind < heights.length - 1 && l <= heights[ind+1]){
//            b++;
//            ind++;
//        }
//
//         ans.push(l * b);
//
//         if(ind >= heights.length - 1){
//            return;
//        }
//
//         largestArea(heights, Math.min(l, heights[ind + 1]), b+1, ans, ind+1);
//    }

    private static void largestArea(int[] heights, int l, int b, Stack<Integer> ans, int ind) {
         while(ind < heights.length - 1 && l <= heights[ind+1]){
            b++;
            ind++;
        }

         if(ans.peek() < l*b){
            ans.pop();
            ans.push(l*b);
        }

         if(ind >= heights.length - 1){
            return;
        }

         largestArea(heights, Math.min(l, heights[ind + 1]), b+1, ans, ind+1);
    }
}
