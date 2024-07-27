import java.util.Arrays;

class Scratch {
    public static void main(String[] args){
        int[] nums = {98,54,6,34,66,63,52,39};
        System.out.println(Arrays.toString(nums));
        System.out.println(buyChoco(nums, 60));


    }

    static int buyChoco(int[] prices, int money) {
        insertionSort(prices);
        if(prices[0] + prices[1] > money)
            return money;
        return (prices[0] + prices[1]) - money;
    }

    static void insertionSort(int[] nums){
        for(int i=0; i<nums.length-1; i++){
            for(int j= i+1; j>0; j--){
                if (nums[j] < nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
                else
                    break;
            }
        }
    }
}