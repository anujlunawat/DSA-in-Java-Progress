public class DeleteNodeInBST450 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

//    public static TreeNode deleteNode(TreeNode root, int key) {
//        if(root == null)
//            return null;
//
//        if(root.val == key)
//            return deleteRoot(root);
//
//        TreeNode deletedNodeParent = searchNode(root, key);
//
//        if(deletedNodeParent == null)
//            return root;
//
//        TreeNode deletedNode = deletedNodeParent.val < key ? deletedNodeParent.right : deletedNodeParent.left;
//
//        if(deletedNode.right != null){
//            extremeLeft(deletedNode.right).left = deletedNode.left;
//
//            if(deletedNodeParent.left == deletedNode)
//                deletedNodeParent.left = deletedNode.right;
//            else{
//                deletedNodeParent.right = deletedNode.right;
//            }
//        }
//        else{
//            if(deletedNodeParent.left == deletedNode)
//                deletedNodeParent.left = deletedNode.left;
//            else{
//            deletedNodeParent.right = deletedNode.left;
//            }
//        }
//        return root;
//    }

    private static TreeNode searchNode(TreeNode root, int key){
        if(root == null)
            return null;
        if(root.left != null && root.left.val == key)
            return root;
        if(root.right != null && root.right.val == key)
            return root;

        TreeNode left = searchNode(root.left, key);
        TreeNode right = searchNode(root.right, key);

        if(left != null)
            return left;
        return right;
    }

    private static TreeNode extremeLeft(TreeNode root){
        if(root.left == null)
            return root;
        return extremeLeft(root.left);
    }

    private static TreeNode deleteRoot(TreeNode root){
        if (root.right != null) {
            extremeLeft(root.right).left = root.left;
            return root.right;
        }
        return root.left;
    }

    public static TreeNode deleteNode(TreeNode root, int key){
        if(root == null)
            return null;

        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else{
            if(root.right == null)
                return root.left;
            else if(root.left == null)
                return root.right;

            TreeNode extremeLeft = extremeLeft(root.right);
            extremeLeft.left = root.left;
            return root.right;
        }
        return root;
    }

    public static void main(String[] args) {
         TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(7);

        System.out.println(deleteNode(root, 3));
    }
}
