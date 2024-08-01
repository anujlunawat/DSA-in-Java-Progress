public class Pattern13 {
    public static void main(String[] args) {
        pattern13(10);
    }
    
    public static void pattern13(int n){
        for (int row = 0; row < n; row++) {
            for (int spaces = 0; spaces < n-row-1; spaces++) {
                System.out.print(" ");
            }
            for(int col = 0; col < (2*row)+1; col++){
                if(row == n-1)
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
