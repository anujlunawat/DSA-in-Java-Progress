import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] arr = {1,2,2};

        List<List<Integer>> ans = subset2(arr);
        for(List<Integer> x: ans)
            System.out.println(x);
    }

    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for(int n: arr){
            int size = outer.size();
            for (int i = 0; i < size; i++) {

                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(n);

                if (!outer.contains(inner))
                    outer.add(inner);
            }
        }
        return outer;
    }

    static List<List<Integer>> subset2(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for(int j = 0; j < arr.length; j++){
            int n = arr[j];
            boolean repeat = j > 0 && (arr[j] == arr[j - 1]);

            int start = 0;
            int size = outer.size();
            if(repeat)
                start = size / 2;

            for (int i = start; i < size; i++) {

                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(n);

               outer.add(inner);
            }
        }
        return outer;
    }

    static List<List<Integer>> subset3(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for(int j = 0; j < arr.length; j++){
            int n = arr[j];
            int ind = find(arr, j);


            int start = 0;
            int end = outer.size();
            if(ind != -1) {
//                difference between the present index and the index with the duplicate
                int diff = j-ind;
                start = end / (2*diff);
                end = (int)Math.pow(2, ind);
            }

            for (int i = start; i < end; i++) {

                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(n);

                if (!outer.contains(inner))
                    outer.add(inner);
            }
        }
        return outer;
    }

    static int find(int[] arr, int i){
        for(int j = 0; j < i; j++){
            if (arr[j] == arr[i])
                return j;
        }
        return -1;
    }

}
