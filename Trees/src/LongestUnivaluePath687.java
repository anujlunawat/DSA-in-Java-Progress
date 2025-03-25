public class LongestUnivaluePath687 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public int longestUnivaluePath(TreeNode root) {
        helper(root, root.val);
        return ans;
    }
    int ans = 0;
    private int helper(TreeNode root, int val){
        if(root == null)
            return 0;

        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);

        ans = Math.max(left + right, ans);
        if(root.val == val){
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
