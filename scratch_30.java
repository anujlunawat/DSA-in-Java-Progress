import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] position = {1,2,3,4,7};
        int m = 3;

        System.out.println(maxDistance(position, m));
    }
    static int maxDistance(int[] position, int m){
        Arrays.sort(position);
        int start = 0;
        int end = Math.ceilDiv(position[position.length-1], m);
        int ans = -1;

        if(m > position.length)
            return -1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            boolean possible = isPossible(position, m, mid);

            if(possible){
                start = mid+1;
                ans = mid;
            }
            else
                end = mid-1;
        }
        return ans;
    }

    static boolean isPossible(int[] position, int m, int dist){
        int prevValue = position[0];
        m--;
        for(int i=1; i<position.length && m>0; i++){
            if(position[i] - prevValue >= dist){
                m--;
                prevValue = position[i];
            }
        }
        if(m <= 0)
            return true;
        return false;
    }
}