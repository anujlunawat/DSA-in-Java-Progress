import java.util.ArrayList;
import java.util.List;

public class BTLevelOrderTraversalII107 {
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int k = levels(root);

        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        helper(root, k-1, ans);
        return ans;
    }

    private int levels(TreeNode node){
        if(node == null)
            return 0;
        return 1 + Math.max(levels(node.left), levels(node.right));
    }

    private void helper(TreeNode node, int n, List<List<Integer>> ans){
        if(node == null)
            return;
        ans.get(n).add(node.val);
        helper(node.left, n-1, ans);
        helper(node.right, n-1, ans);
    }
}
