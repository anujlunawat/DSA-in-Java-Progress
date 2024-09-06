import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> s = new ArrayList<>();
        combinations(candidates, target, new ArrayList<>(), 0, s, 0);
        System.out.println(s);
    }

    static void combinations(int[] candidates, int target, List<Integer> p, int sum, List<List<Integer>> s, int start){
        if(sum == target){
            s.add(new ArrayList<>(p));
            return;
        }

        if(sum > target)
            return;

        for(int i = start; i < candidates.length; i++){
            if(sum + candidates[i] <= target){
                p.add(candidates[i]);
                combinations(candidates, target, p, sum+candidates[i], s, i);
                p.removeLast();
            }
        }
    }
    static void combinations2(int[] candidates, int target, List<Integer> p, int sum, List<List<Integer>> s, int start) {
        if (sum == target) {
            s.add(new ArrayList<>(p));
            return;
        }

        if (sum > target || start >= candidates.length)
            return;

        if (sum + candidates[start] <= target) {
            p.add(candidates[start]);
            combinations2(candidates, target, p, sum + candidates[start], s, start);
            p.removeLast();
        }

        combinations2(candidates, target, p, sum, s, start+1);
    }
}
