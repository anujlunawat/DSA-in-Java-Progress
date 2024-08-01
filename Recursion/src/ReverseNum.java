public class ReverseNum {
    public static void main(String[] args) {
        System.out.println(reverse1(98760));
        System.out.println(reverse2(98760));
    }

    static String reverse1(int n){
        StringBuilder s = new StringBuilder(n+"");
        s.reverse();
        return s.toString();
    }

    static int reverse2(int n){
        if(n%10 == n)
            return n;
        int pow = (int) Math.pow(10, (int)Math.log10(n));
        return ((n%10) * pow) + reverse2(n/10);
    }
}
