public class Pattern1 {
    public static void main(String[] args) {
        pattern1(5);
    }

    public static void pattern1(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
