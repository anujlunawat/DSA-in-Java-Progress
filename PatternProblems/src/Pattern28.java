public class Pattern28 {
    public static void main(String[] args) {
        pattern28(10);
    }

    static void pattern28(int n){
        for (int row = 1; row <= (n * 2) - 1; row++) {
//            if row > n -> row - n
            int sp = (row > n ? (row - n) : n-row);
            for (int spaces = 0; spaces < sp; spaces++) {
                System.out.print(" ");
            }

            int stars = (row > n ?  n - (row - n) : row);
            for(int i = stars; i > 0; i--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
