public class Pattern8 {
    public static void main(String[] args) {
        pattern8(5);
    }

    public static void pattern8(int n){
        for (int row = 1; row <= n; row++) {
            for (int spacing = n; spacing > row; spacing--) {
                System.out.print(" ");
            }
            for (int col = 0; col < ((row-1)*2)+1; col++) {
                System.out.print("*");
            }
            for (int spacing = n; spacing > row; spacing--) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
