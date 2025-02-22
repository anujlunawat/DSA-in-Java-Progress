public class PopulatingNextRightPointersInEachNodeII117 {
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
            return null;

        connectRec(root);
        return root;
    }

    private static void connectRec(Node node){
        if(node == null)
            return;

        if(node.left != null){
//            immediate right
            if(node.right != null) {
                node.left.next = node.right;
            }
            else{
                connectMissing(node, node.left);
            }
        }

        if (node.right != null) {
            connectMissing(node, node.right);
        }


        if(node.left != null)
            connectRec(node.left);
        if(node.right != null)
            connectRec(node.right);
    }

    private static void connectMissing(Node node, Node rl){
        Node temp = node;
        while(temp.next != null){
            if(temp.next.left != null){
                rl.next = temp.next.left;
                break;
            }
            if(temp.next.right != null){
                rl.next = temp.next.right;
                break;
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

        root.left.left = new Node(0);
        root.left.right = new Node(7);
        root.right.left = new Node(9);
        root.right.right = new Node(1);

        root.left.left.left = new Node(2);
        root.left.right.left = new Node(1);
        root.left.right.right = new Node(0);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(8);

        root.left.right.right.left = new Node(7);  // 7 is now the left child of 0 at level 4

        connect(root);
    }
}
