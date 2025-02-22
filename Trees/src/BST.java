import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {
    private class Node{
        int value;
        Node left;
        Node right;
        int level;

        Node(int value){
            this.value = value;
        }
    }

    private Node root;

    BST(){

    }

    public int height(Node node){
        if(node == null)
            return -1;
        return node.level;
    }

    public boolean isEmpty(Node node){
        return root == null;
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
        return node;
    }

    public void populate(int[] nums){
        for (int num : nums) insert(num);
    }

    public void populateSorted(int[] nums){
//        root = populateSorted(nums, 0, nums.length - 1);
        populateSorted2(nums, 0, nums.length-1);
    }

    private Node populateSorted(int[] nums, int start, int end){
        if(start > end){
            return null;
        }

        int mid = start + (end - start) / 2;
        Node node = new Node(nums[mid]);
        node.right = populateSorted(nums, mid + 1, end);
        node.left = populateSorted(nums, start, mid-1);
        return node;
    }
    private void populateSorted2(int[] nums, int start, int end){
        if(start > end){
            return;
        }

        int mid = start + (end - start) / 2;
        insert(nums[mid]);
        populateSorted2(nums, mid + 1, end);
        populateSorted2(nums, start, mid-1);
    }

    public void inorder(){
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
        System.out.print("Inorder: ");
        inOrderIterative(root);
    }

    private void inorder(Node node){
        if(node == null)
            return;
        inorder(node.left);
        System.out.print(node.value + ", ");
        inorder(node.right);
    }

    private void inOrderIterative(Node root){
        Stack<Node> ans = new Stack<>();
        Node current = root;

        while(current != null || !ans.isEmpty()){
            while(current != null){
                ans.push(current);
                current = current.left;
            }

            current = ans.pop();
            System.out.print(current.value + " -> ");

            current = current.right;
        }

    }

    public void preorder(){
        System.out.println();
        System.out.print("Preorder: ");
        preorder(root);
    }
    private void preorder(Node node){
        if(node == null)
            return;
        System.out.print(node.value + ", ");
        preorder(node.left);
        preorder(node.right);
    }
    public void postorder(){
        System.out.println();
        System.out.print("Postorder: ");
        postorder(root);
    }
    private void postorder(Node node){
        if(node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + ", ");
    }

    public void levelOrder(){
        levelOrder(root);
    }

    private void levelOrder(Node node){
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            System.out.print(curr.value + " -> ");

            if(curr.left != null)
                q.add(curr.left);
            if(curr.right != null)
                q.add(curr.right);
        }

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
        BST tree = new BST();
//        tree.insert(15);
//        tree.insert(10);
//        tree.insert(90);
//        tree.insert(5);
//        tree.insert(11);
//        tree.insert(100);
//        tree.insert(24);
        int[] nums = {5,6,1,3,4,9,7,2,8,10};
        tree.populate(nums);
//        tree.prettyPrint();
//        tree.inorder();
//        tree.preorder();
//        tree.postorder();
//        tree.levelOrder();
        tree.inorder();

    }
}
