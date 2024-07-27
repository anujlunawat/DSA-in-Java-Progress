public class MountainArray {
    public static void main(String[] args){
        int[] arr = {0,2, 1, 0};
        System.out.println(mountainArray(arr));
    }

    static int mountainArray(int[] arr){
//        this solution is from leetcode
//        do check this out
        int start=0;
        int end=arr.length-1;
        while(start <= end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }

         return start;
















//        int start=0, end=arr.length-1;
//
//        while(start <= end){
//            int mid = start + (end-start)/2;
//
//            if(mid > 0 && mid < arr.length-1){
//                if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
//                    return mid;
//            }
//            if (mid<=0)
//                start=mid+1;
//            else if (mid>=arr.length-1)
//                end=mid-1;
//            else if(arr[mid] > arr[mid-1])
//                start = mid+1;
//            else
//                end = mid-1;
//        }
//        return end;
    }
}
