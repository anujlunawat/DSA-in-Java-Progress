public class KthMissingPosNumber1539 {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        System.out.println(findKthPositive(arr, 5));
    }
    static int findKthPositive(int[] arr, int k) {
        int start = 0, end = arr.length-1;

        while(start < end){
            int mid = start + (end-start)/2;
            int nums_missed = arr[mid] - (mid+1);

            if(nums_missed >= k)
                end = mid;
            else
                start = mid+1;
        }
        int nums_missed = arr[end] - (end+1);
        if (nums_missed < k)
            return arr[end]+(k - nums_missed);
        return (arr[end] - (nums_missed - k)) - 1;
    }
}
