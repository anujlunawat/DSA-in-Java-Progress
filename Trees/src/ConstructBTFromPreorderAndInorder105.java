import java.util.Arrays;

public class ConstructBTFromPreorderAndInorder105 {
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

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length -1, 0);
    }

    private static TreeNode helper(int[] preorder, int[] inorder, int inorderStart, int inorderEnd, int preorderStart){
        if(preorderStart >= preorder.length || inorderEnd < inorderStart)
            return null;

        TreeNode root = new TreeNode(preorder[preorderStart]);

        if(inorderStart == inorderEnd)
            return root;

//        index value of root in inorder array
        int rootInInorder = search(inorder, inorderStart, root.val);

//        go left
        preorderStart += 1;
        root.left = helper(preorder, inorder, inorderStart, rootInInorder - 1, preorderStart);
//        go right
        preorderStart += (rootInInorder - inorderStart);
        root.right = helper(preorder, inorder, rootInInorder + 1, inorderEnd, preorderStart);

        return root;
    }

    private static int search(int[] arr, int ind, int target){
        if(arr[ind] == target)
            return ind;
        return search(arr, ind+1, target);
    }

    private static TreeNode buildTree2(int[] preorder, int[] inorder){
        if(inorder.length == 0 || preorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        if(inorder.length == 1)
            return root;

        int rootIndex = search(inorder, 0, root.val);

//        go left
        int preorderEnd = rootIndex + 1;
        root.left = buildTree2(Arrays.copyOfRange(preorder, 1, preorderEnd), Arrays.copyOfRange(inorder, 0, rootIndex));

//        go right
        int preorderStart = preorderEnd;
        root.right = buildTree2(Arrays.copyOfRange(preorder, preorderStart, preorder.length), Arrays.copyOfRange(inorder, rootIndex+1, inorder.length));

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] preorder = {3,9,20,15,7};

        System.out.println(buildTree2(preorder, inorder).val);
    }
}
