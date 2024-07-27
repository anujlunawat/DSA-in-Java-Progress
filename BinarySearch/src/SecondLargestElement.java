public class SecondLargestElement {
    public static void main(String[] args){
        int[] arr = {1,2,3,99,76,90,23,67,45,89,100};
        System.out.println(secondLargestElement(arr));
    }

    static int largestElement(int[] arr){
        int max=arr[0];
        for (int i: arr){
            max = i>max ? i : max;
        }

        return max;
    }

    static int secondLargestElement(int[] arr){
        int max = largestElement(arr);
        int second_max = -999999999;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) continue;
            second_max = (arr[i] > second_max ? arr[i] : second_max);
        }
        return second_max;
    }
}
