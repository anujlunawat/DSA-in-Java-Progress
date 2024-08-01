public class Pattern9 {
    public static void main(String[] args) {
        pattern9(5);
    }
    public static void pattern9(int n){
        for (int row = 1; row <= n; row++) {
            for (int spacing = row-1; spacing > 0; spacing--) {
                System.out.print(" ");
            }
            for (int col = 0; col < ((n-(row-1))*2)-1; col++) {
                System.out.print("*");
            }
            for (int spacing = row-1; spacing > 0; spacing--) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
