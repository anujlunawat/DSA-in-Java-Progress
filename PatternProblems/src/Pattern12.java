public class Pattern12 {
    public static void main(String[] args) {
        pattern12(5);
    }
    public static void pattern12(int n){
        for (int row = 0; row < n*2; row++) {
            int stars = row >= n ? row-n+1 : n-row;
            int spaces = row >= n ? n-(row-n)-1 : row;

            for (int spacing = 0; spacing < spaces; spacing++) {
                System.out.print(" ");
            }
            for (int col = 0; col < stars; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
