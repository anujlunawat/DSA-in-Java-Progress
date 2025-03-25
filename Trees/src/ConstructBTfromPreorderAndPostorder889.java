import com.sun.source.tree.Tree;

import java.util.Arrays;

public class ConstructBTfromPreorderAndPostorder889 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
//        return helper(preorder, postorder);
        return helper(preorder, postorder, 0, preorder.length, 0, preorder.length - 1);
    }
//    private TreeNode helper(int[] preorder, int[] postorder, int preorderStart, int size, int postorderStart){
//        if(preorderStart >= preorder.length || postorderStart < 0)
//            return null;
//
//        TreeNode root = new TreeNode(preorder[preorderStart]);
//        if(size == 1){
//            return root;
//        }
//
////        for left
//        preorderStart += 1;
//        int leftSize = (size - 1) / 2;
//
//
//        root.left = helper();
//        root.right = helper();
//    }

    private static TreeNode helper(int[] preorder, int[] postorder){
        if(preorder.length == 0 || postorder.length == 0)
            return null;

//        first node in preorder is the root
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length == 1)
            return root;

        int nextRoot = preorder[1];
        int posOfNextRootInPostOrder = search(postorder, nextRoot, 0);
        int leftEnd = (posOfNextRootInPostOrder + 1);

        root.left = helper(Arrays.copyOfRange(preorder, 1, leftEnd + 1), Arrays.copyOfRange(postorder, 0, leftEnd));
        root.right = helper(Arrays.copyOfRange(preorder, leftEnd + 1, preorder.length), Arrays.copyOfRange(postorder, leftEnd, postorder.length - 1));

        return root;
    }

    private static TreeNode helper(int[] preorder, int[] postorder, int leftStart, int size, int preStart, int rightEnd){
        if(size <= 0) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        if(size == 1 || preStart == preorder.length - 1)
            return root;

        preStart += 1;
        int posOfNextRootInPostOrder = search(postorder, preorder[preStart], 0);
        int leftEnd = posOfNextRootInPostOrder;
        int rightStart = leftEnd + 1;

        size = leftEnd - leftStart + 1;
        rightEnd = rightStart + size - (preorder.length % 2 == 0 ? 1 : 0) - 1;

        root.left = helper(preorder, postorder, leftStart, size, preStart, rightEnd);

        preStart += size;
        if(preStart < preorder.length && rightEnd > rightStart) {
            size = preorder.length % 2 == 0 ? size + 1 : size;
            root.right = helper(preorder, postorder, rightStart, size, preStart, rightEnd);
        }

        return root;
    }

    private static int search(int[] arr, int target, int ind){
        if(arr[ind] == target)
            return ind;
        return search(arr, target, ind+1);
    }

    public static void main(String[] args) {
        int[] preorder = {3,4,1,2};
        int[] postorder = {1,4,2,3};

        System.out.println(constructFromPrePost(preorder, postorder));

    }
}
