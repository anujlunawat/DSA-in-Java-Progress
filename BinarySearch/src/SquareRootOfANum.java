public class SquareRootOfANum {
    public static void main(String[] args) {
        System.out.println(squareRoot(0));
    }

    static int squareRoot(int n){
        int start=1, end=(n/2)+1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if (mid * mid == n)
                return mid;
            else if(mid * mid > n)
                end = mid-1;
            else
                start = mid+1;
        }
        return end;
    }
}
