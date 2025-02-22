public class MinDepthOfBT111 {

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
    public static void main(String[] args) {

    }
//    public int minDepth(TreeNode root) {
//        if(root == null)
//            return 0;
//    }
    private int minDepth2(TreeNode root){
        if(root.left == null && root.right == null)
            return 1;
        int l = 0, r = 0;
        if(root.left != null){
            l = 1 + minDepth2(root.left);
        }
        if(root.right != null)
            r = 1 + minDepth2(root.right);
        if(l == 0)
            return r;
        if(r == 0)
            return l;
        return Math.min(l, r);
    }
}
