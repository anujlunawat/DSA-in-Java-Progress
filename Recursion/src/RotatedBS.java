class RotatedBS {
    public static void main(String[] args) {
        int[] arr = {5,6,7,1, 3};
        System.out.println(rotatedBS(arr, 0, arr.length-1, 6));
    }

    static int rotatedBS(int[] arr, int start, int end , int target){
        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;

        if (arr[mid] == target)
            return mid;

        if(arr[start] < arr[mid]){
            if(target >= arr[start] && target < arr[mid])
                return rotatedBS(arr, start, mid-1, target);
            return rotatedBS(arr, mid+1, end, target);
        }

        else{
            if(target <= arr[end] && target > arr[mid])
                return rotatedBS(arr, mid+1, end, target);
            return rotatedBS(arr, start, mid-1, target);

        }
    }

    static int rotatedBS2(int[] arr, int start, int end , int target){
        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;

        if (arr[mid] == target)
            return mid;

        if(arr[start] < arr[mid]){
            if(target >= arr[start] && target < arr[mid])
                return rotatedBS2(arr, start, mid-1, target);
            return rotatedBS2(arr, mid+1, end, target);
        }

        else{
            if(target <= arr[end] && target > arr[mid])
                return rotatedBS2(arr, mid+1, end, target);
            else if (target > arr[end] && target < arr[mid])
                return rotatedBS2(arr, start, mid-1, target);
            else if(target > arr[mid] && target >= arr[end])
                return rotatedBS2(arr, start, mid-1, target);
            else if(target < arr[mid] && target < arr[end])
                return rotatedBS2(arr, mid+1, end, target);
        }
        return -1;
    }
}