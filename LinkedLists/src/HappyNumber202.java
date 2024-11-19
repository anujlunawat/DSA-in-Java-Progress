public class HappyNumber202 {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
//    public static boolean isHappy(int n) {
//        int slow = -1;
//        int fast = n;
//
//        while(n != 1 && fast != 1){
//            if (fast == slow){
//                return false;
//            }
//            n = squareOfDigits(n);
//            slow = n;
//            fast = squareOfDigits(squareOfDigits(fast));
//        }
//
//        return true;
//    }
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do{
            slow = squareOfDigits(slow);
            fast = squareOfDigits(squareOfDigits(fast));
        }while(slow != fast);

        if(slow == 1)
            return true;

        return false;
    }

    public static int squareOfDigits(int n){
        if(n == 0){
            return 0;
        }
        return (n%10) * (n%10) + squareOfDigits(n/10);
    }
}
