public class AVLTree {
    private class Node{
        int value;
        Node left;
        Node right;
        int height;

        Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public int height(){
        return height(root);
    }

    private int height(Node node){
        if(node == null)
            return -1;
        return node.height;
    }

    public void insert(int value){
        root = insert(value, root);
    }

    private Node insert(int value, Node node){
        if(node == null){
            return new Node(value);
        }
        if(value < node.value){
            node.left = insert(value, node.left);
        }

        else {
            node.right = insert(value, node.right);
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        return rotate(node);
    }

    private Node rotate(Node node){
        int balanceFactor = height(node.left) - height(node.right);
        if(balanceFactor > 1){
//            left heavy
            if(height(node.left.left) - height(node.left.right) > 0){
//                new node has been added to left of left (left of child node)
//                LL case
                return rightRotate(node);
            }
//            LR case
            if(height(node.left.left) - height(node.left.right) < 0){
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        else if(balanceFactor < -1){
//            right heavy
            if(height(node.right.left) - height(node.right.right) > 0){
//                new node has been added to left of right (left of child node)
//                RL case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
//            RR case
            if(height(node.right.left) - height(node.right.right) < 0){
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node leftRotate(Node parentNode) {
        Node child = parentNode.right;
        Node temp = child.left;
        child.left = parentNode;
        parentNode.right = temp;

        parentNode.height = Math.max(height(parentNode.left), height(parentNode.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;
        return child;
    }

    private Node rightRotate(Node parentNode) {
        Node child = parentNode.left;
        Node temp = child.right;
        child.right = parentNode;
        parentNode.left = temp;

        parentNode.height = Math.max(height(parentNode.left), height(parentNode.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;
        return child;
    }

    public void populate(int[] nums){
        for(int n: nums)
            insert(n);
    }

    public void prettyPrint(){
        prettyPrint(root, 0);
    }

    private void prettyPrint(Node node, int level){
        if(node == null)
            return;
        prettyPrint(node.right, level + 1);

        if(level != 0){
            for(int i = 0; i < level-1; i++){
                System.out.print("\t");
            }
            System.out.println("|------->" + node.value);
        }
        else{
            System.out.println(node.value);
        }
        prettyPrint(node.left, level + 1);
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

//        for (int i = 0; i < 1000; i++)
//            tree.insert(i);
        tree.populate(nums);
        tree.prettyPrint();
//        System.out.println(tree.height());
    }

}
