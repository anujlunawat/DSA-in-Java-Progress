public class MaxProductOfSplittedBT1339 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    static int ans = Integer.MIN_VALUE;
    static double mod = 1e9 + 7;
    public static int maxProduct(TreeNode root) {
        helper(root, root);
        return ans;
    }

    private static void helper(TreeNode root, TreeNode realRoot){
        if(root == null)
            return;

        if(root.left != null){
            TreeNode temp = root.left;
            root.left = null;
            result(realRoot, temp);
            root.left = temp;

            helper(root.left, realRoot);
        }

        if(root.right != null){
            TreeNode temp = root.right;
            root.right = null;
            result(realRoot, temp);
            root.right = temp;

            helper(root.right, realRoot);
        }

    }

    private static int sum(TreeNode root){
        if(root == null)
            return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

    private static void result(TreeNode nodeA, TreeNode nodeB){
        int sumA = sum(nodeA);
        int sumB = sum(nodeB);

        sumA *= sumB;
        sumA %= (int) mod;
        ans = Math.max(ans, sumA);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(6);

        System.out.println(maxProduct(root));
    }
}
