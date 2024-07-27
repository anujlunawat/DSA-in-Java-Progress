public class FibonacciSeq {
    public static void main(String[] args) {
//        fibo(0, 1, 10, 0);
//        System.out.println(fibo2(20));
        System.out.println(fibo3(10));
    }

    static int fibo(int i, int j, int index, int currindex){
        if(currindex > index)
            return j;
        System.out.print(i + " ");
        return fibo(j, i+j, index, currindex+1);
    }

    static int fibo2(int i){
        if(i <= 1)
            return i;
        return fibo2(i-1) + fibo2(i-2);
    }

//    Binet's formula
    static double fibo3(int n){
        final double PHI = (Math.sqrt(5) + 1) / 2;
        final double phi = PHI-1;

        return ((Math.pow(PHI, n) - Math.pow(-phi, n)) / Math.sqrt(5));
    }
}
