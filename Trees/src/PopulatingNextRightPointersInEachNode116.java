import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode116 {
    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static Node connect(Node root) {
        if(root == null)
            return root;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int currentLevel = queue.size();
            for (int i = 0; i < currentLevel; i++) {
                Node currentNode = queue.poll();

                if(currentNode.left != null)
                    queue.offer(currentNode.left);
                if(currentNode.right != null)
                    queue.offer(currentNode.right);

                if(i != currentLevel - 1)
                    currentNode.next = queue.peek();
                else
                    currentNode.next = null;
            }
        }

        return root;
    }

//    private static void connectRecursive(Node left , Node right){
//        if(left.left == null)
//            return;
//        left.left.next = left.right;
//        left.right.next = right.left;
//
//        right.left.next = right.right;
//        if(right.next != null)
//            right.right.next = right.next.left;
//
//        connectRecursive(left.left, left.right);
//        connectRecursive(right.left, right.right);
//    }

//    DONE ON OWN
    private static void connectRecursive(Node node){
        if(node.left == null)
            return;

        node.left.next = node.right;
        if(node.next != null)
            node.right.next = node.next.left;

        connectRecursive(node.left);
        connectRecursive(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        root.left = node1;
        root.right = node2;

        Node node3 =new Node(4);
        Node node4 =new Node(5);
        Node node5 =new Node(6);
        Node node6 =new Node(7);

        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        connect(root);
        System.out.println(root.next);
    }

}
