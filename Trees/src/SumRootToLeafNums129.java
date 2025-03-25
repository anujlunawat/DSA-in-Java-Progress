public class SumRootToLeafNums129 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    int ans = 0;
    public void sumNumbers(TreeNode root, int sum) {
        if(root == null)
            return;

        sum = ((sum * 10) + root.val);
        if(root.left == null && root.right == null){
            ans += sum;
            return;
        }
        sumNumbers(root.left, sum);
        sumNumbers(root.right, sum);
    }

    public int sumNumbers2(TreeNode root, int sum){
        if(root == null)
            return 0;

        sum = (sum * 10) + root.val;

        if(root.left == null && root.right == null)
            return sum;

        int left = sumNumbers2(root.left, sum);
        int right = sumNumbers2(root.right, sum);

        return left + right;
    }
}
