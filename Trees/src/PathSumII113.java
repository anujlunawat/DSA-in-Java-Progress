import java.util.ArrayList;
import java.util.List;

public class PathSumII113 {
    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
        }

    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, new ArrayList<>());
        return ans;
    }

    public static void helper(TreeNode root, int targetSum, List<Integer> path) {
        if(root == null)
            return;

        targetSum -= root.val;
        path.add(root.val);
        if(targetSum == 0 && root.left == null && root.right == null){
            ans.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        helper(root.left, targetSum, path);
        helper(root.right, targetSum, path);
        path.removeLast();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 22));
    }
}
