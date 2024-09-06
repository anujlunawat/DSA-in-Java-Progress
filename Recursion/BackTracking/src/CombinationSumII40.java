//not completed
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSumII40 {
    public static void main(String[] args) {
        int[] candidates = {2,5,1,1,2,3,3,3,1,2,2};
        int target = 5;
        candidates = mergeSort(candidates);

        List<List<Integer>> s = new ArrayList<>();
        combinations(candidates, target, new ArrayList<>(), 0, s, 0);
        System.out.println(s);
    }

    static void combinations(int[] candidates, int target, List<Integer> p, int sum, List<List<Integer>> s, int start){
        if(sum == target){
            for(List<Integer> t: s){
                if(t.containsAll(p) && p.containsAll(t))
                    return;
            }
            s.add(new ArrayList<>(p));
            return;
        }

        if(sum > target)
            return;

        for(int i = start; i < candidates.length; i++){
            if(sum + candidates[i] <= target){
                p.add(candidates[i]);
                combinations(candidates, target, p, sum+candidates[i], s, i+1);
                p.removeLast();
            }
        }
    }

    static int[] mergeSort(int[] arr){
        if(arr.length == 1)
            return arr;

        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right){
        int[] mix = new int[left.length + right.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < left.length && j < right.length){
            if (left[i] < right[j])
                mix[k++] = left[i++];
            else
                mix[k++] = right[j++];
        }

        while(i < left.length){
            mix[k++] = left[i++];
        }
        while(j < right.length){
            mix[k++] = right[j++];
        }
        return mix;
    }
}
