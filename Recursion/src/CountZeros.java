public class CountZeros {
    public static void main(String[] args) {
        System.out.println(zeros(30210040));
    }

    static int zeros(int num){
        if(num%10 == num)
            return num == 0 ? 1 : 0;

        int z = (num%10 == 0 ? 1 : 0);
        return z + zeros(num/10);
    }
}
