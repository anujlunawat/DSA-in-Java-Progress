public class CeilingBS {
    public static void main(String[] args){
        int[] arr = {0,1,2,3,5,7,9,12,19};
        int target = 35;
        System.out.println(ceiling(arr, target));
    }

    static int ceiling(int[] arr, int target){
        int start=0, end=arr.length-1;

        while (start <= end){
            int midpoint = start + (end - start) / 2;

            if (arr[midpoint] == target)
                return midpoint;

            else if(arr[midpoint] > target)
                end = midpoint - 1;
            else
                start = midpoint + 1;
        }return start;
    }
}
