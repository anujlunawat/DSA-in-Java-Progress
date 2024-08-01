public class Pattern6 {
    public static void main(String[] args) {
        pattern6(5);
    }

    public static void pattern6(int n){
        for (int row = 1; row <= n; row++) {
//            spacing at each row
            for(int spacing = n-row; spacing > 0; spacing--)
                System.out.print(" ");

            for (int col = 0; col < row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
