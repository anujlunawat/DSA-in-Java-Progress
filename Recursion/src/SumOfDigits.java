public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sum(1234560));
    }

    static int sum(int n){
        if(n<=0)
            return 1;
        return n%10 * sum(n/10);
    }
}
