import java.util.*;

public class CombinationSum39 {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        List<List<Integer>> t = new ArrayList<>(combinations(arr, new ArrayList<>(), 7));
        List<List<Integer>> a = new ArrayList<>();
    }

    static List<List<Integer>> combinations(int[] candidates, List<Integer> p, int target){
        if(target == 0){
            List<List<Integer>> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < candidates.length; i++) {
            if(candidates[i] <= target) {
                List<Integer> a = new ArrayList<>(p);
                a.add(candidates[i]);
                List<List<Integer>> t = combinations(candidates, a, target-candidates[i]);
                System.out.println(t);

                if(ans.isEmpty())
                    ans.addAll(t);
                
                for (int j = 0; j < ans.size() && !t.isEmpty(); j++) {
                    if(ans.get(i).containsAll(t.getFirst())){
                        break;
                    }
                    else if(j == ans.size()-1)
                        ans.addAll(t);
                }
            }
        }
        return ans;
    }
}
