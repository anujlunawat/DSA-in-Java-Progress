// stack overflow error
public class Pow50 {
    public static void main(String[] args) {
        System.out.println(myPow(.00001, 2147483647));
    }

    static double myPow(double x, int n){
        if(n==0)
            return 1;

        if(n < 0)
            return (1.0/x) * myPow(x, n+1);

        return x * myPow(x, n-1);
    }
}
