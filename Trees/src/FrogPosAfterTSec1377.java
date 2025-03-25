import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FrogPosAfterTSec1377 {

    public static double frogPosition(int n, int[][] edges, int t, int target) {
        if(edges[0][0] == target)
            return 1;
        modifyArr(edges);
        return helper(edges[0][0], edges, t, target, 0, 1);
    }

    private static double helper(int n, int[][] edges, int t, int target, int index, double currentProbability){
//        if(target == n)
//            return currentProbability;
        if(t == 0 && target != n){
            return 0;
        }

        int numOfChildren = countChildren(n, edges, index);

        if(target == n){
            if(t != 0 && numOfChildren != 0)
                return 0;
            return currentProbability;
        }

        currentProbability /= numOfChildren;

        for (int i = index; i < index + numOfChildren; i++) {
            double h = helper(edges[i][1], edges, t-1, target, index + numOfChildren, currentProbability);
            if(h != 0)
                return h;
        }
        return 0;
    }

    private static void modifyArr(int[][] edges){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(edges[0][0]);

        int size = 0;
        while(!queue.isEmpty()){
            int lastOccuredIndex = size;
            int currentParent = queue.poll();

            for(int i = size; i < edges.length; i++){
                if(edges[i][0] == currentParent){
                    size++;
                    queue.offer(edges[i][1]);
                }
                else if(edges[i][1] == currentParent){
                    int temp = edges[i][1];
                    edges[i][1] = edges[i][0];
                    edges[i][0] = temp;
                    size++;

                    queue.offer(edges[i][1]);
                }

                if(edges[i][0] == currentParent) {
                    if (i != lastOccuredIndex) {
                        int[] temp = edges[i];
                        edges[i] = edges[lastOccuredIndex];
                        edges[lastOccuredIndex] = temp;
                    }
                    lastOccuredIndex++;

                }
            }
        }
    }

    private static int countChildren(int n, int[][] edges, int index){
        int count = 0;
        for (int i = index; i < edges.length; i++) {
            if(edges[i][0] == n) count++;
//            else break;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] edges = {
                        {2, 1},
                        {3, 2},
                        {4, 1},
                        {5, 1},
                        {6, 4},
                        {7, 1},
                        {8, 7}
                    };


//        System.out.println(frogPosition(7, edges, 10,3));
        System.out.println(frogPosition(8, edges, 7, 7));
    }
}
