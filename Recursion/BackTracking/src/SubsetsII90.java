import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubsetsII90 {

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] nums = {1,2,2};
        List<Integer> up = Arrays.stream(nums)      // Convert the int array to IntStream
                                          .boxed()              // Convert each int to Integer
                                          .collect(Collectors.toList()); // Collect the stream into a List<Integer>
;
        subsetsWDup(ans, up,new ArrayList<>());
        System.out.println(ans);
    }

    static void subsetsWDup(List<List<Integer>> ans, List<Integer>up, List<Integer> p){
        if(up.isEmpty()){
            if(!ans.contains(p))
                ans.add(new ArrayList<>(p));
            return;
        }

//        remove the first element of up
//        and add it to p
        Integer f = up.removeFirst();

        subsetsWDup(ans, up, p);

        p.add(f);
        subsetsWDup(ans, up, p);

//        undo the changes
        p.removeLast();
        up.addFirst(f);
    }
}
