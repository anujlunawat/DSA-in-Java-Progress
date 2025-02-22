import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoiGFG {
    public static void main(String[] args) {
        int n = 2;
        List<Integer> rod1 = new ArrayList<>();
        for(int i = n; i > 0; i--){
            rod1.add(i);
        }

        List<Integer> rod2 = new ArrayList<>();
        List<Integer> rod3 = new ArrayList<>();

        towerOfHanoi(n, rod1, rod2, rod3, 0);
    }

    private static void towerOfHanoi(int n, List<Integer> rod1, List<Integer> rod2, List<Integer> rod3, int steps) {
        if(rod3.size() == n){
            System.out.println("Steps: " + steps);
            return;
        }

//        when rod3 is empty
        if(rod3.isEmpty()){
//            if rod1 is not empty, add from rod1 to rod3
            if(!rod1.isEmpty()){
                rod3.add(rod1.removeLast());
                towerOfHanoi(n, rod1, rod2, rod3, steps + 1);
            }
//            if rod1 is empty and rod3 empty, rod2 is surely not empty
//            add from rod2 to rod3
            else{
                rod3.add(rod2.removeLast());
                towerOfHanoi(n, rod1, rod2, rod3, steps + 1);
            }
        }

//        from rod1 to rod3
        else if(!rod1.isEmpty() && rod3.getLast() > rod1.getLast()){
            rod3.add(rod1.removeLast());
            towerOfHanoi(n, rod1, rod2, rod3, steps + 1);
        }
//        from rod2 to rod3
        else if(!rod2.isEmpty() && rod3.getLast() > rod2.getLast()){
             rod3.add(rod2.removeLast());
            towerOfHanoi(n, rod1, rod2, rod3, steps + 1);
        }

//        else if(rod1.isEmpty()){
//            if()
//        }
    }
}
