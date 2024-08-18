public class Pattern14 {
    public static void main(String[] args) {
        pattern14(5);
    }

    public static void pattern14(int n){
        for (int row = n; row >= 0; row--) {
            for (int spaces = n-row; spaces > 0; spaces--) {
                System.out.print(" ");
            }
            for(int col = 0; col < (2*row)+1; col++){
                if(row == n)
                    System.out.print("*");
                else if(col == 0 || col == 2*row)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
