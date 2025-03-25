import java.util.Arrays;

public class HouseRobberIICode360 {
    static long[] arr;
    public static long houseRobber(int[] valueInHouse) {
        if (valueInHouse.length == 1)
            return valueInHouse[0];

        arr = new long[valueInHouse.length];

        Arrays.fill(arr, -1);
//        ignore last element
        long ans1 = helper(valueInHouse.length - 2, valueInHouse, 0);
        Arrays.fill(arr, -1);
//        ignore first element
        long ans2 = helper(valueInHouse.length - 1, valueInHouse, 1);
        return Math.max(ans1, ans2);



////        ignore last element
//        long ans1 = helper(valueInHouse.length - 2, Arrays.copyOfRange(valueInHouse, 0, valueInHouse.length - 1));
//        Arrays.fill(arr, -1);
////        ignore first element
//        long ans2 = helper(valueInHouse.length - 2, Arrays.copyOfRange(valueInHouse, 1, valueInHouse.length));
//        return Math.max(ans1, ans2);
    }

////    memoization
//    private static long helper(int n, int[] value){
//        if(n < 0)
//            return 0;
//        if(n == 0)
//            return value[0];
//        if(arr[n] != -1)
//            return arr[n];
//
//        long take = helper(n-2, value) + value[n];
//        long skip = helper(n-1, value);
//
//        arr[n] = Math.max(take, skip);
//        return arr[n];
//    }

//    memoization
    private static long helper(int n, int[] value, int start){
        if(n < start)
            return 0;
        if(n == start)
            return value[start];
        if(arr[n] != -1)
            return arr[n];

        long take = helper(n-2, value, start) + value[n];
        long skip = helper(n-1, value, start);

        arr[n] = Math.max(take, skip);
        return arr[n];
    }

//    tabulation
    private static long helper2(int n, int[] value){
        if(value.length == 1)
            return value[0];

        arr = new long[value.length];
        long max = Math.max(value[0], value[1]);;
//        when i = 1, we are ignoring the last element
//        when i = 2, we are ignoring the first element
        for(int i = 1; i < 3; i++){
            Arrays.fill(arr, -1);
            arr[0] = value[0];
            arr[1] = value[1];
//            arr[2] = value[2];
            for (int j = i; j < value.length - 2 + i; j++) {
                long take = value[j] + (j == i ? 0 : arr[j-2]);
                long skip = arr[j-1];

                arr[j] = Math.max(take, skip);
            }
            max = Math.max(max, arr[arr.length-3+i]);
        }
        return max;
    }

    //    tabulation space optimization
    private static long helper3(int[] value){
        if(value.length == 1)
            return value[0];

        arr = new long[value.length];
        long max = Math.max(value[0], value[1]);

//        when i = 1, we are ignoring the last element
//        when i = 2, we are ignoring the first element
        for(int i = 1; i < 3; i++){
            long prevprev = -1;
            long prev = value[i-1];

            for (int j = i; j < value.length - 2 + i; j++) {
                long take = value[j] + (prevprev == -1 ? 0 : prevprev);
                long skip = prev;

                prevprev = prev;
                prev = Math.max(take, skip);
            }
            max = Math.max(max, prev);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] value = {59, 53, 41, 26, 17, 13, 11};
//        System.out.println(Arrays.toString(Arrays.copyOfRange(value, 1, 2)));
        System.out.println(houseRobber(value));
        System.out.println(helper2(value.length, value));
        System.out.println(helper3(value));
    }
}
