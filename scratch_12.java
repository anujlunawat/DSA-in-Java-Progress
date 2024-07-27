class Scratch {
    public static void main(String[] args) {
        System.out.println(sqrt(4));
    }

    static int sqrt(int num){
        int start = 1, end = num/2 +1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(mid*mid == num*num)
                return mid;
            else if(mid*mid > num*num)
                end = mid-1;
            else
                start = mid+1;
        }
        return end;
    }
}