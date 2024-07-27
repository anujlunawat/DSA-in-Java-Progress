public class OrderAgnosticBS {
    public static void main(String[] args){
        int[] arr = new int[]{1,1,1,1,1,1,1,1};
        System.out.println(orderAgnosticBS(arr, 1));
    }

    static int orderAgnosticBS(int[] arr, int target){
        int s=0;
        int e=arr.length-1;

        boolean isAsc = arr[s] < arr[e];

        while(s<=e){
            int mid = s + (e-s)/2;

            if (arr[mid] == target) return mid;

            if (isAsc){
                if (arr[mid] > target)
                    e = mid-1;
                else
                    s = mid+1;
            }
            else{
                if (arr[mid] < target)
                    e = mid-1;
                else
                    s = mid+1;
            }


        }return -1;
    }
}
