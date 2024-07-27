class Scratch {
    public static void main(String[] args) {
        System.out.println(NthRoot(6, 4096));
        System.out.println(nToM(85, 6));
    }

    static int NthRoot(int n, int num)
    {
        int start=1, end = num/n + 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nToM(mid, n) == num)
                return mid;
            else if(nToM(mid, n) > num)
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }

    static double nToM(long n, long m){
        double t = 1;

        for(long i=0; i<m;i++)
            t*=n;
        return t;
    }
}