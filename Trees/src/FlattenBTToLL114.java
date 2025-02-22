import java.util.LinkedList;
import java.util.Queue;

public class FlattenBTToLL114 {
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

//    public void flatten(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        preOrderTraversal(root, queue);
//
//        while(!queue.isEmpty()){
//            TreeNode node = queue.poll();
//            node.right = queue.peek();
//        }
//    }

    private void preOrderTraversal(TreeNode node, Queue<TreeNode> queue){
        if(node == null)
            return;
        queue.offer(node);
        preOrderTraversal(node.left, queue);
        preOrderTraversal(node.right, queue);
    }

    public void flatten(TreeNode root){
        flatten2(root);
    }
    private TreeNode flatten2(TreeNode node){
        if(node == null)
            return null;

        if(node.left == null){
            if(node.right != null)
                return flatten2(node.right);
            return node;
        }

        TreeNode leftEnd = flatten2(node.left);
        TreeNode temp = node.right;
        node.right = node.left;
        leftEnd.right = temp;
        node.left = null;

        if(temp != null)
            return flatten2(temp);
        return leftEnd;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(8);

        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(7);

        root.left.left.left.left = new TreeNode(5);
        root.left.left.left.right = new TreeNode(6);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(11);
    }
}
