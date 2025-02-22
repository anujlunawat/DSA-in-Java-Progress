import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal102 {
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

    private void levelOrder(List<List<Integer>> ans, Queue<TreeNode> queue){
        if(queue.isEmpty())
            return;
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> a = new ArrayList<>();

        while(!queue.isEmpty()){
            if(queue.peek().left != null)
                q.add(queue.peek().left);
            if(queue.peek().right != null)
                q.add(queue.peek().right);
            a.add(queue.poll().val);
        }
        ans.add(a);
        levelOrder(ans, q);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        queue.offer(root);

        List<Integer> a = new ArrayList<>();

        while(!queue.isEmpty()) {
            if (queue.peek().left != null)
                q.add(queue.peek().left);
            if (queue.peek().right != null)
                q.add(queue.peek().right);
            a.add(queue.poll().val);
            if (queue.isEmpty()) {
                ans.add(new ArrayList<>(a));
                a.clear();
                queue = new LinkedList<>(q);
                q.clear();
            }
        }
        return ans;
    }
}
