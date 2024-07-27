import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];

        for(int i=0, j=0, k=0; i < nums1.length || j < nums2.length;k++){
            if(i >= nums1.length){
                nums3[k] = nums2[j++];
            }

            else if(j >= nums2.length){
                nums3[k] = nums1[i++];
            }

            else if (nums1[i] < nums2[j]){
                nums3[k] = nums1[i++];
            }
            else{
                nums3[k] = nums2[j++];
            }
        }


        System.out.println(Arrays.toString(nums3));

        if(nums3.length%2 == 0){
            return (nums3[nums3.length / 2] + nums3[(nums3.length / 2) - 1]) / 2.0;
        }
        return nums3[nums3.length / 2];
    }
}