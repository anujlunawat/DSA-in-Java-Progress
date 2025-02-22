import com.sun.source.tree.Tree;

import java.util.*;

public class BTZigZagTraversal103 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

//    public List<List<Integer>> levelOrder(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        List<List<Integer>> ans = new ArrayList<>();
//        if(root == null)
//            return ans;
//        queue.add(root);
//        levelOrder(ans, queue);
//        return ans;
//    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null)
            return ans;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean zigZag = true;

        while(!queue.isEmpty()){
            List<Integer> a = new ArrayList<>();
            int level = queue.size();
            zigZag = !zigZag;

            for(int i = 0; i < level; i++) {
                TreeNode currentNode;
                if (zigZag) {
                    currentNode = queue.removeLast();

                    if (currentNode.right != null)
                        queue.addFirst(currentNode.right);
                    if (currentNode.left != null)
                        queue.addFirst(currentNode.left);
                }

                else{
                    currentNode = queue.poll();

                    if (currentNode.left != null)
                        queue.offer(currentNode.left);
                    if (currentNode.right != null)
                        queue.offer(currentNode.right);
                }
                a.add(currentNode.val);
            }

            ans.add(a);
        }
        return ans;
    }

//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> ans = new ArrayList<>();
//        if(root == null)
//            return ans;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        boolean zigzag = true;
//
//        while(!queue.isEmpty()){
//            List<Integer> a = new ArrayList<>();
//            int level = queue.size();
//            zigzag = !zigzag;
//            for(int i = 0; i < level; i++){
//                TreeNode currentNode = queue.poll();
//                if (currentNode.left != null)
//                    queue.offer(currentNode.left);
//                if (currentNode.right != null)
//                    queue.offer(currentNode.right);
//                a.add(currentNode.val);
//            }
//            if(zigzag)
//                a = a.reversed();
//            ans.add(a);
//        }
//        return ans;
//    }

//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> ans = new ArrayList<>();
//
//        if(root == null)
//            return ans;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while(!queue.isEmpty()){
//            List<Integer> a = new ArrayList<>();
//            int level = queue.size();
//
//            for(int i = 0; i < level; i++){
//                TreeNode currentNode = queue.poll();
//                a.add(currentNode.val);
//                if (currentNode.left != null)
//                    queue.offer(currentNode.left);
//                if (currentNode.right != null)
//                    queue.offer(currentNode.right);
//            }
//            if(ans.size() % 2 != 0)
//                a = a.reversed();
//            ans.add(a);
//        }
//        return ans;
//    }
}
