public class FloorBS {
    public static void main(String[] args){
        int[] arr = new int[]{2, 3, 5, 9, 14, 16, 18};
        System.out.println(floorBS(arr, 20));
    }

    static int floorBS(int[] arr, int target){
        int start = 0, end = arr.length-1;

        while(start < end){
            int midpoint = start + ((end - start) / 2);

            if (arr[midpoint] == target)
                return midpoint;
            else if (arr[midpoint] > target)
                end = midpoint - 1;
            else
                start = midpoint + 1;
        }
        return end;
    }
}
