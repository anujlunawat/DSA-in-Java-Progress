package src;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    public static void main (String[] args) throws java.lang.Exception{
        int[] stalls = {4,2,1,3,6};
        int cows=2;
        Arrays.sort(stalls);
        System.out.println(aggressiveCows(stalls, cows));


    }

    static int aggressiveCows(int[] stalls, int cows){
        int start=1;
        int end = Math.ceilDiv(stalls[stalls.length-1], cows);

        while(start <= end){
            int mid = start + (end - start) / 2;
            boolean minimum_distance = minDist(stalls, mid, cows);

            if(!minimum_distance)
                end = mid-1;
            else
                start = mid+1;
        }
        return end;
    }

    static boolean minDist(int[] stalls, int dist, int cows){
        int prev_stall = stalls[0];
        cows--;
        for(int i=1; i<stalls.length && cows>0; i++){
            if(stalls[i] - prev_stall >= dist){
                cows--;
                prev_stall = stalls[i];
            }
        }
        if (cows<=0)
            return true;
        return false;
    }




    static void sort(int[] stalls){
        for(int i=0; i<stalls.length-1; i++){
            for(int j=i+1; j>0; j--){
                if(stalls[j] < stalls[j-1]){
                    int temp = stalls[j];
                    stalls[j] = stalls[j-1];
                    stalls[j-1] = temp;
                }
            }
        }
    }
}
