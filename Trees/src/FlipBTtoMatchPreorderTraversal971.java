import java.util.ArrayList;
import java.util.List;

public class FlipBTtoMatchPreorderTraversal971 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    List<Integer> ans = new ArrayList<>();
    public int helper(TreeNode root, int[] voyage, int index) {
        if(root == null || index == voyage.length - 1)
            return index;
        if(root.val != voyage[index]){
            return -1;
        }
        if(root.left != null && index < voyage.length - 1 && root.left.val != voyage[index + 1]){
            if(root.right != null && root.right.val != voyage[index + 1]){
                return -1;
            }
            if(root.right != null && root.right.val == voyage[index + 1]){
                ans.add(root.val);
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
            }
        }
        int nextInd = helper(root.left, voyage, index+1);
        if(nextInd == -1)
            return -1;
        return helper(root.right, voyage, nextInd);
    }
}
