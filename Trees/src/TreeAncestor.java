//import java.util.ArrayList;
//import java.util.List;
//
////1483. Kth Ancestor of a Tree Node
//public class TreeAncestor {
//
////    int[] parent;
////    public TreeAncestor(int n, int[] parent) {
////        this.parent = parent;
////    }
////
////    public int getKthAncestor(int node, int k) {
////        if(node == -1 || node > parent.length - 1)
////            return -1;
////        if(k == 0)
////            return node;
////        return getKthAncestor(parent[node], k-1);
////    }
//    List<List<Integer>> ans = new ArrayList<>();
//    public TreeAncestor(int n, int[] parent) {
//        int i = 0;
//        List<Integer> temp = new ArrayList<>();
//        temp.add(-1);
//        ans.add(temp);
//
//        while(i <= ans.size()) {
//            List<Integer> a = new ArrayList<>();
//            for(int j = 0; j < ans.get(i).size(); j++){
//                while()
//            }
//        }
//    }
//
//    public int getKthAncestor(int node, int k) {
//
//    }
//
//
//}