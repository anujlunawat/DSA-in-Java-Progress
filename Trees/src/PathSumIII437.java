public class PathSumIII437 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    static int ans = 0;
    public static int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        helper(root, targetSum);
        return ans;
    }
    private static void helper(TreeNode root, int targetSum){
        if(root == null)
            return;
        anotherHelper(root, targetSum);

        helper(root.left, targetSum);
        helper(root.right, targetSum);
    }

    private static void anotherHelper(TreeNode root, long targetSum){
        if(root == null)
            return;

        targetSum -= root.val;
        if(targetSum == 0){
            ans++;
        }
        anotherHelper(root.left, targetSum);
        anotherHelper(root.right, targetSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1000000000);
        root.left = new TreeNode(1000000000);
        root.left.right = new TreeNode(294967296);
        root.left.right.right = new TreeNode(1000000000);
        root.left.right.right.right = new TreeNode(1000000000);
        root.left.right.right.right.right = new TreeNode(1000000000);

        System.out.println(pathSum(root, 0));
    }
}
