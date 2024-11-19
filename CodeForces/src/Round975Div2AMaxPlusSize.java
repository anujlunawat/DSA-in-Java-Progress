import java.util.Arrays;
import java.util.Scanner;

public class Round975Div2AMaxPlusSize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(ans());
        }
    }

    private static int ans() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        System.out.println("n = " + n);
        int[] nums = new int[n];

        int max = Integer.MIN_VALUE;
        int max_ind = 0;
        for (int j = 0; j < n; j++) {
            nums[j] = scanner.nextInt();
            if (nums[j] > max) {
                max = nums[j];
                max_ind = j;
            }
//            System.out.println("here");
        }

        if (max_ind % 2 == 0)
            return max + (n / 2) + 1;
        return max + (n / 2);

    }

//    private static int ans(int n, int[] nums){
//
//            int max = Integer.MIN_VALUE;
//            int max_ind = 0;
//            for (int j = 0; j < n; j++){
//                if(nums[j] > max){
//                    max = nums[j];
//                    max_ind = j;
//                }
//            }
//                if(max_ind % 2 == 0)
//                    return max + (n / 2) + 1;
//                return max + (n / 2);
//    }
}
