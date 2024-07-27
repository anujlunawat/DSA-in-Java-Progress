import java.util.Arrays;

public class MinimumNumOfDaysToMakeBouquets1482 {
    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int m = 3;
        int k = 1;
        System.out.println(minDays(bloomDay, m, k));
    }

    static int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length)
            return -1;

        int start = maxMinEle(bloomDay, false);
        int end = maxMinEle(bloomDay, true);
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(isBloomed(bloomDay, m, k, mid)){
                ans = mid;
                end = mid-1;
            }
            else
                start = mid+1;
        }
        return ans;
    }



    static boolean isBloomed(int[] bloomDay, int m, int k, int days){
//        for(int i=0; i<bloomDay.length; i++)
//            bloomDay[i] = bloomDay[i] > days ? bloomDay[i] - days : 0;

        int mcpy=0, kcpy=0;
        while(kcpy <= bloomDay.length-k){
            if(mcpy == m)
                return true;

            int bloomed = inLine(bloomDay, kcpy, k+kcpy-1, days);

//            if you are using the below if statement and the inLine function that returns boolean
//            it will take hell lot of time to compile
//            see for yourself
//            if(inLine(bloomDay, kcpy, k+kcpy-1, days))
            if(bloomed == -1){
                mcpy++;
                kcpy += k;
            }
            else
                kcpy = bloomed+1;
        }
        if(mcpy == m)
                return true;
        return false;
    }

//    static boolean inLine(int[] arr, int lo, int hi, int days){
//        for(int i=lo; i<=hi; i++){
//            if(arr[i] > days)
//                return false;
//        }
//        return true;
//    }
    static int inLine(int[] arr, int lo, int hi, int days){
        for(int i=lo; i<=hi; i++){
//            if at some index the flower has not bloomed
//            it will return the index so that kcpy can start after that index
            if(arr[i] > days)
                return i;
        }
        return -1;
    }

    static int maxMinEle(int[] bloomDay, boolean max){
        int n = bloomDay[0];
        if(max)
            for(int x: bloomDay)
                n = x > n ? x : n;
        else
            for(int x: bloomDay)
                n = x < n ? x : n;
        return n;
    }
}
