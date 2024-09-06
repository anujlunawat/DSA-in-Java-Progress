// stack overflow error
public class Pow50 {
    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }
    static double myPow(double x, int n){
        if(n == 0)
            return 1;

        if(n % 2 == 0){
            n /= 2;
            x *= x;

        }

        if(n > 0)
            return x * myPow(x, n-1);
        return (1/x) * myPow(x, n+1);

    }


}
