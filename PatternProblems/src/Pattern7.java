public class Pattern7 {
    public static void main(String[] args) {
        pattern7(5);
    }

     public static void pattern7(int n){
        for (int row = 1; row <= n; row++) {
//            spacing at each row
            for(int spacing = row-1; spacing > 0; spacing--)
                System.out.print(" ");

            for (int col = 0; col <= n-row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
