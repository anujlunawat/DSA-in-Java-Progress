public class ValidateBST98
{
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

    public static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private static boolean helper(TreeNode root, Integer minVal, Integer maxVal){
        if(root == null)
            return true;
        if((maxVal != null && root.val >= maxVal) || (minVal != null && root.val <= minVal))
            return false;
        return helper(root.left, minVal, root.val) && helper(root.right, root.val, maxVal);
    }
//    private static boolean goRight(TreeNode root, int minVal, int maxVal){
//        if(root == null)
//            return true;
//        if(root.val < minVal || root.val > maxVal)
//            return false;
//        return goLeft(root.left, root.val - 1) && goRight(root.right, root.val + 1);
//    }


    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5, new TreeNode(4), new TreeNode(6));
        tree.right.left = new TreeNode(3);
        tree.right.right = new TreeNode(7);
        System.out.println(isValidBST(tree));

    }
}
