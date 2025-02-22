//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Stack;
//
//public class AsteroidCollision735 {
//    public static void main(String[] args) {
//        int[] asteroid = {-2,-1,1,2};
//        System.out.println(Arrays.toString(asteroidCollision(asteroid)));
//    }
//    public static int[] asteroidCollision(int[] asteroids) {
//        Stack<Integer> right = new Stack<>();
//        Stack<Integer> left = new Stack<>();
//        ArrayList<Integer> ans = new ArrayList<>();
//
//        for (int size : asteroids) {
//            if (size < 0) {
//                left.push(size);
//            }
//            else {
//                right.push(size);
//                while (!left.isEmpty()) {
//                    ans.add(left.removeFirst());
//                    ans.
//                }
//            }
//
//            if (size < 0) {
//                while (!right.isEmpty()) {
//                    if (right.peek() == Math.abs(size)) {
//                        left.pop();
//                        right.pop();
//                        break;
//                    } else if (right.peek() < Math.abs(size))
//                        right.pop();
//                    else {
//                        left.pop();
//                        break;
//                    }
//                }
//            }
//        }
//
//        while(!left.isEmpty()) {
//            ans.add(left.removeFirst());
////            left.removeFirst();
//        }
//        while(!right.isEmpty()) {
//            ans.add(right.removeFirst());
////            right.removeFirst();
//        }
//
////        int[] a = ans.stream().mapToInt(Integer::intValue).toArray();;
//        return ans.stream().mapToInt(Integer::intValue).toArray();
//    }
//}
