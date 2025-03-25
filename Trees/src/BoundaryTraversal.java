import java.util.ArrayList;

public class BoundaryTraversal {
    static class Node
    {
        int data;
        Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    static ArrayList<Integer> ans = new ArrayList<>();
    static ArrayList<Integer> boundaryTraversal(Node node) {
        ans.add(node.data);
        leftBoundary(node.left);
        helper(node);
        rightBoundary(node.right);
        return ans;
    }

    static void helper(Node node){
        if(node == null)
            return;
        if(node.left == null && node.right == null){
            ans.add(node.data);
            return;
        }
        helper(node.left);
        helper(node.right);
    }

    static void leftBoundary(Node node){
        if(node == null || (node.left == null && node.right == null))
            return;
        ans.add(node.data);
        if(node.left != null)
            leftBoundary(node.left);
        else
            leftBoundary(node.right);
    }

    static void rightBoundary(Node node){
        if(node == null || (node.left == null && node.right == null))
            return;
        if(node.right != null)
            rightBoundary(node.right);
        else
            rightBoundary(node.left);
        ans.add(node.data);
    }

    public static Node createTestTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

//        root.left.left = new Node(4);
//        root.left.right = new Node(12);
//        root.right.right = new Node(5);
        root.right.left = new Node(4);
        root.right.left.left = new Node(5);
//        root.left.right.left = new Node(10);
//        root.left.right.right = new Node(14);
//
//        root.left.right.left.left = new Node(9);
//        root.left.right.right.right = new Node(15);

        return root;
    }
    public static void main(String[] args) {
        Node root = createTestTree();
        System.out.println(boundaryTraversal(root));
    }
}
