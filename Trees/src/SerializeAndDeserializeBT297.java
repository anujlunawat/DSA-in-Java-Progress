import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SerializeAndDeserializeBT297 {
     public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
     }


    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null)
            return "null ";
        StringBuilder s = new StringBuilder();
        s.append(root.val).append(" ");

//        go left
        s.append(serialize(root.left));
//        go right
        s.append(serialize(root.right));

        return s.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] ans = data.split(" ");
        return deserialize(ans);
    }
    private static int index = 0;
    private static TreeNode deserialize(String[] data){
        if(data.length == 0 || Objects.equals(data[index], "null")) {
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(data[index++]));

//        go left
        root.left = deserialize(data);
//        go right
        root.right = deserialize(data);

        return root;
    }


    private static void prettyPrint(TreeNode node, int level){
        if(node == null)
            return;
        prettyPrint(node.right, level + 1);

        if(level != 0){
            for(int i = 0; i < level-1; i++){
                System.out.print("\t");
            }
            System.out.println("|------->" + node.val);
        }
        else{
            System.out.println(node.val);
        }
        prettyPrint(node.left, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        // Connect nodes manually
        root.left = node9;
        root.right = node20;
        node20.left = node15;
        node20.right = node7;

        String data = serialize(root);
        System.out.println(data);
        root = deserialize(data);
        prettyPrint(root, 0);
    }
}
