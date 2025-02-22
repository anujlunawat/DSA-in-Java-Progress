import java.util.ArrayList;
import java.util.List;

public class SumOfLeftLeaves404 {
    public static class TreeNode {
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

    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode node, boolean isLeft){
        if(node == null)
            return 0;
        if(node.left == null && node.right == null && isLeft)
            return node.val;
        return sumOfLeftLeaves(node.left, true) + sumOfLeftLeaves(node.right, false);
    }
}
