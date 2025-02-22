import java.util.Scanner;

public class BinaryTree {

    private class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public void populate(Scanner scanner){
        System.out.println("Enter the value of root node: ");
        int val = scanner.nextInt();
        root = new Node(val);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node){
//        adding Node to the left of the root Node
        System.out.println("Do you want any Node to the left of " + node.value +": ");
        boolean left = scanner.nextBoolean();

        if(left) {
            System.out.println("Enter value of the left Node: ");
//            int val = scanner.nextInt();
//            Node leftNode = new Node(scanner.nextInt());
//            root.left = leftNode;
            node.left = new Node(scanner.nextInt());
            populate(scanner, node.left);
        }

//        adding Node to the right of the root Node
        System.out.println("Do you want any Node to the right of " + node.value +": ");
        boolean right = scanner.nextBoolean();

        if(right){
            System.out.println("Enter value of the right Node: ");
            node.right = new Node(scanner.nextInt());
            populate(scanner, node.right);
        }
    }

    public void display(){
        display(root, "");
    }

    private void display(Node node, String indent){
        if (node == null)
            return;
        System.out.println(indent + node.value);
        display(node.left, indent+"\t");
        display(node.right, indent+"\t");
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
        BinaryTree tree = new BinaryTree();
        tree.populate(new Scanner(System.in));
//        tree.display();
         tree.prettyPrint();
    }
}
