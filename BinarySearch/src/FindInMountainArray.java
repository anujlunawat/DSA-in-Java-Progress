//problem 1095
public class FindInMountainArray {
    public static void main(String[] args){
        int[] arr = {3,5,3,2,0};
        System.out.println(findInMountainArray(3, arr));
//        System.out.println(binarySearch(new int[]{0,5,3,1}, 1, 2, 3, false));
    }

    static int findInMountainArray(int target, int[] mountainArr) {
        int peak_element = peakElement(mountainArr);
        int inc = binarySearch(mountainArr, target, 0, peak_element, true);

        if (inc==-1){
            return binarySearch(mountainArr, target, peak_element+1, mountainArr.length-1, false);
        }
        return inc;


    }

//    static int peakElement(int[] mountainArr){
//        int start=0, end = mountainArr.length -1;
//
//        while(start < end){
//            int mid = start + (end - start) / 2;
//
//            if(mountainArr[mid] < mountainArr[mid-1])
//                end = mid-1;
//            else
//                start = mid+1;
//        }
//        return end;
//    }


    static int peakElement(int[] mountainArr){
        int start=0, end = mountainArr.length -1;

        while(start < end){
            int mid = start + (end - start) / 2;

            if(mountainArr[mid] < mountainArr[mid+1])
                start = mid+1;
            else
                end = mid;
        }
        return start;
    }

    static int binarySearch(int[] mountainArr, int target, int start, int end, boolean isAsc){
        while (start <= end){
            int mid = start + (end-start)/2;

            if(mountainArr[mid] == target)
                return mid;

            else if (isAsc){
                if (mountainArr[mid] > target)
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            else {
                if (mountainArr[mid] < target)
                    end = mid - 1;
                else
                    start = mid + 1;
            }

        }return -1;
    }
}

