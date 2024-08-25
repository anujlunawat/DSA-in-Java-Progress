import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSrc2Target797 {
    public static void main(String[] args) {
        int[][] graph = {
                {4,3,1},
                {3,2,4},
                {3},
                {4},
                {}
        };
        List<Integer> path = new ArrayList<>();
        path.add(0);
        System.out.println(allPathsRet(graph, 0, path));
    }

    static void allPaths(int[][] graph, int r, String path){
        if(r >= graph.length-1){
            System.out.println("Path found: " + path);
        }

        for (int col = 0; col < graph[r].length; col++) {
            allPaths(graph, graph[r][col], path + graph[r][col]);
        }
    }
    static List<List<Integer>> allPathsRet(int[][] graph, int r, List<Integer> path){
        if(r >= graph.length-1){
            List<List<Integer>> t = new ArrayList<>();
            t.add(path);
            return t;
        }

        List<List<Integer>> t = new ArrayList<>();

        for (int col = 0; col < graph[r].length; col++) {
            List<Integer> u = new ArrayList<>(path);
            u.add(graph[r][col]);
            t.addAll(allPathsRet(graph, graph[r][col], u));
        }
        return t;
    }
}
