import java.util.Stack;

public class VerticalOrderTraversal {
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

    public static void verticalOrderTraversal(TreeNode root){
         Stack<TreeNode> stack = new Stack<>();

         if(root == null)
             return;

         stack.push(root);
         while(!stack.isEmpty()){
             TreeNode temp = stack.peek();
             if(temp.left != null){
                 stack.push(temp.left);
                 continue;
             }
             System.out.print(stack.pop().val + " ");
             if(!stack.isEmpty()){
                 temp = stack.pop();
                 System.out.print(temp.val + " ");
             }
             if(temp.right != null){
                 stack.push(temp.right);
             }
         }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.right.left.left = new TreeNode(10);
        root.right.left.right = new TreeNode(11);

        verticalOrderTraversal(root);
    }
}
