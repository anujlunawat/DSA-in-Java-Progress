public class CousinsInBT993 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        return (level(root, x, 0) == level(root, y, 0)) && (!isSiblings(root,x,y));
    }

    private static int level(TreeNode node, int val, int level){
        if(node == null)
            return 0;
        if(node.val == val)
            return level;
        return Math.max(level(node.left, val, level+1), level(node.right, val, level+1));
    }

    private static int level2(TreeNode node, int val){
        if(node == null)
            return -1;
        if(node.val == val)
            return 0;
        return 1 + Math.max(level2(node.left, val), level2(node.right, val));
    }

    private static boolean isSiblings(TreeNode node, int x, int y){
        if(node == null)
            return false;

        if(node.left != null){
            if(node.left.val == x || node.left.val == y){
                if(node.right != null){
                    if(node.right.val == y || node.right.val == x)
                        return true;
                }
                return false;
            }
        }
        if(node.right != null){
            if(node.right.val == y || node.right.val == x)
                return false;
        }

//        if((node.left.val == x || node.right.val == x) && (node.left.val == y || node.right.val == y))
//            return true;
        return isSiblings(node.left, x, y) || isSiblings(node.right, x, y);
    }

    public static void main(String[] args) {
       // Constructing the tree manually in the main method
       TreeNode root = new TreeNode(1);
       root.left = new TreeNode(2);
       root.right = new TreeNode(3);

       root.left.left = new TreeNode(4);
//       root.right.right = new TreeNode(5);
//       System.out.println(level(root, 4, 0));
//       System.out.println(level(root, 5, 0));
       System.out.println(level2(root, 4));
       System.out.println(level2(root, 3));
       System.out.println(isCousins(root, 4, 5));
   }
}
