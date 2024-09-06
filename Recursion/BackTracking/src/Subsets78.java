import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Subsets78 {
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] nums = {1,2,3};
        List<Integer> up = Arrays.stream(nums)      // Convert the int array to IntStream
                                          .boxed()              // Convert each int to Integer
                                          .collect(Collectors.toList()); // Collect the stream into a List<Integer>
;
        subsets(ans, up,new ArrayList<>());
        System.out.println(ans);
    }

    static void subsets(List<List<Integer>> ans, List<Integer>up, List<Integer> p){
        if(up.isEmpty()){
            ans.add(new ArrayList<>(p));
            return;
        }

//        remove the first element of up
//        and add it to p
        Integer f = up.removeFirst();
        p.add(f);
        subsets(ans, up, p);

//        undo the changes
        p.removeLast();
//        up.addFirst(f);

//        Integer l = up.removeFirst();
        subsets(ans, up, p);
        up.addFirst(f);

    }
}
