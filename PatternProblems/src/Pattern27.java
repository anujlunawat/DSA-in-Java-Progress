
public class Pattern27 {
    public static void main(String[] args) {
        pattern27(4);
    }


    static void pattern27(int rows){
        int a = 1, b = sum(rows)*2 + 1;
        for(int r = rows; r > 0; r--){
            for (int spaces = 0; spaces < rows-r; spaces++) {
                System.out.print("  ");
            }
            for (int i = 0; i < r; i++) {
                System.out.print(a++ + " ");
            }
            System.out.print(" ");

            b -= r;
            for (int j = 0; j < r; j++){
                System.out.print(b++ + " ");
            }
            b -= r;

            System.out.println();
        }
    }

    static int sum(int n){
        if (n <= 0)
            return 0;
        return n + sum(n-1);
    }
}
