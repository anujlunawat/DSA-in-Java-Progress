public class BTMaxPathSum124 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    static int ans = Integer.MIN_VALUE;
    public static int helper(TreeNode root) {
        if(root == null)
            return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        left = Math.max(0, left);
        right = Math.max(0, right);

        int pathSum = left + right + root.val;
        ans = Math.max(pathSum, ans);

        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);
        root.left.left.left = new TreeNode(-1);

        helper(root);
        System.out.println(ans);
    }
}
