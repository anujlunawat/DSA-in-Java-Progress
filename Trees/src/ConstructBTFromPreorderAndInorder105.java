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
        int rootInInorder = search(inorder, 0, root.val);

//        go left
        root.left = helper(preorder, inorder, inorderStart, rootInInorder - 1, preorderStart + 1);
//        go right
        preorderStart = preorderStart + 1 + (rootInInorder - inorderStart);
        root.right = helper(preorder, inorder, rootInInorder + 1, inorderEnd, preorderStart);

        return root;
    }

    private static int search(int[] arr, int ind, int target){
        if(arr[ind] == target)
            return ind;
        return search(arr, ind+1, target);
    }
    public static void main(String[] args) {
        int[] inorder = {1,2};
        int[] preorder = {1, 2};

        System.out.println(buildTree(preorder, inorder).val);
    }
}
