public class Pattern3 {
    public static void main(String[] args) {
        pattern3(5);
    }

    public static void pattern3(int n){
        for (int i = 0; i < n; i++) {
            for (int j = n-i; j >0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
