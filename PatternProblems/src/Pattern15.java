public class Pattern15 {
    public static void main(String[] args) {
        pattern15(5);
    }

    public static void pattern15(int n){
        for (int row = 0; row < (n*2)-1; row++) {
            for (int spaces = 0; spaces < Math.abs(row-(n-1)); spaces++) {
                System.out.print(" ");
            }

            System.out.print("*");

            for(int spaces = 0; spaces < (row<n ? (row * 2)-1 : (((n-1)*2)-1) - (row - n + 1) * 2); spaces++)
                System.out.print(" ");

            if (row != 0 && row != (n*2)-2)
                System.out.print("*");

            System.out.println();
        }
    }
}
