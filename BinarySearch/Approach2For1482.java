public class Approach2For1482 {
      public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;
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

            if(inLine2(bloomDay, mid, k, m)){
                ans = mid;
                end = mid-1;
            }
            else
                start = mid+1;
        }
        return ans;
    }


    static boolean inLine2(int[] arr, int days, int k, int m){
        int counter = 0;
        int streak = 0;

        for(int i=0; i<arr.length; i++) {
            if(counter >= m)
                return true;

            if (arr[i] <= days) {
                streak++;
            }
            else{
                counter += (streak / k);
                streak = 0;
            }
        }
        counter += (streak / k);
        if(counter >= m)
            return true;
        return false;
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
