import java.util.Queue;

public class kthSmallestElementInBST230 {
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

//    public static int kthSmallest(TreeNode root, int k) {
//        return helper(root, k);
//        //        Queue<Integer> queue = new LinkedList<>();
////        inOrder(root, queue);
////
////        while(k-- > 1)
////            queue.remove();
////        return queue.peek();
//    }

    private static void inOrder(TreeNode root, Queue<Integer> queue){
        if(root == null)
            return;
        if(root.left != null)
            inOrder(root.left, queue);
        queue.offer(root.val);
        inOrder(root.right, queue);
    }

    static int count = 1;
//    public static int kthSmallest(TreeNode root, int k){
//        if(root.left != null) {
//            int left = kthSmallest(root.left, k);
//            if(left != -1) return left;
//        }
//
//        if(count == k)
//            return root.val;
//
//        count++;
//
//        if(root.right != null) {
//            return kthSmallest(root.right, k);
//        }
//
//        return -1;
//    }

    public static int kthSmallest(TreeNode root, int k){
        if(root == null)
            return -1;

        int left = kthSmallest(root.left, k);
        if(left != -1) return left;

        if(count == k)
            return root.val;

        count++;

        return kthSmallest(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        TreeNode root = new TreeNode(5, new TreeNode(3), new TreeNode(6));
//        root.left.left = new TreeNode(2);
//        root.left.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(24);
        System.out.println(kthSmallest(root, 1));
    }
}
