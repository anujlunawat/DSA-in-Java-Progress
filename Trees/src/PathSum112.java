public class PathSum112 {
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

    public boolean hasPathSum(TreeNode node, int targetSum) {
        if(node == null){
            return false;
        }
        targetSum -= node.val;
        if(targetSum == 0 && node.left == null && node.right == null)
            return true;
//        if(targetSum < 0)
//            return false;

        boolean l = hasPathSum(node.left, targetSum);
        return l || hasPathSum(node.right, targetSum);
    }
}
