import java.util.ArrayList;
import java.util.List;

public class CountGoodNumbers1922 {
    public static void main(String[] args) {
//        List<String> gn = new ArrayList<>();
//        System.out.println(goodNumbers(10, gn, ""));
//        System.out.println(gn);
        System.out.println(countGoodNumbers(5));
    }

//    public static int goodNumbers(long n, List<String> gn, String p) {
//        if(n == 0){
//            gn.add(p);
//            return 1;
//        }
//
//        int count = 0;
//
//        if(p.length() % 2 == 0){
//            count += goodNumbers(n-1, gn, p+"2");
//            count += goodNumbers(n-1, gn, p+"3");
//            count += goodNumbers(n-1, gn, p+"5");
//            count += goodNumbers(n-1, gn, p+"7");
//        }
//        else{
//            count += goodNumbers(n-1, gn, p+"0");
//            count += goodNumbers(n-1, gn, p+"2");
//            count += goodNumbers(n-1, gn, p+"4");
//            count += goodNumbers(n-1, gn, p+"6");
//            count += goodNumbers(n-1, gn, p+"8");
//        }
//        return count;
//    }

    public static int countGoodNumbers(long n) {
        long mod = 1000000007;
        long odd = fun(4, n / 2, mod);
        long even = fun(5, n - n / 2, mod);
        return (int)((odd * even) % mod);
    }

    public static long fun(long x, long y, long mod){
        if (y == 0) {
            return 1;
        }
        long half = fun(x, y / 2, mod);
        half = (half * half) % mod;
        if (y % 2 != 0) {
            half = (half * x) % mod;
        }
        return half;
    }
}
