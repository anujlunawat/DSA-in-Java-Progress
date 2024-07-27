// incomplete program

public class SingleElement {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,4,4,5,5,6,6};
        System.out.println(singleElement(arr));
    }

    static int singleElement(int[] arr){
        int start = 0, end = arr.length-1;

        while (start < end){
            int mid = start + (end - start) / 2;

            if(mid == 0)
                if (arr[mid]!=arr[mid+1])
                return mid;
            else if(mid == arr.length-1)
                if(arr[mid] != arr[mid-1])
                    return mid;

            else if(mid % 2==0) {
                if (arr[mid] == arr[mid + 1])
                    start = mid + 1;
                else if(arr[mid] == arr[mid-1])
                    end = mid - 1;
                else
                    return mid;
            }
            else{
                if(arr[mid] == arr[mid-1])
                    start = mid+1;
                else if(arr[mid] == arr[mid+1])
                    end = mid-1;
                else
                    return mid;
            }
        }return -1;
    }
}
