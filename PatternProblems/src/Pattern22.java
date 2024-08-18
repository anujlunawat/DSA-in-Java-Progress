public class Pattern22 {
    public static void main(String[] args) {
        pattern22(5);
    }

    static void pattern22(int n){
        for(int i = 1; i <= n; i++){
            for (int j = 1, b = (i%2==0 ? 0 : 1); j <= i; j++) {
                System.out.print(b + " ");
                b = (b==1 ? 0 : 1);
            }
            System.out.println();
        }
    }
}
