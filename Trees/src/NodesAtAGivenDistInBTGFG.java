// https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/

import java.util.ArrayList;

public class NodesAtAGivenDistInBTGFG {

    static class Node
    {
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
        }
    }
    static ArrayList<Integer> ans = new ArrayList<>();

    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        if(root == null)
            return ans;

        int leftDist = dist(root.left, target, 1);
        int rightDist = dist(root.right, target, 1);

        boolean goRight = (leftDist != -1);
        int dist = goRight ? leftDist : rightDist;

        if(dist == k)
            ans.add(root.data);

        if(goRight){
            helper(root.right, k, dist+1, true);
            helper(root.left, k, dist-1, false);
        }

        else{
            helper(root.left, k, dist+1, true);
            helper(root.right, k, dist-1, false);
        }

        return ans;
    }

    private static void helper(Node root, int reqDist, int currDist, boolean goRight){
        if(root == null )
            return;
        if(currDist == reqDist){
            ans.add(root.data);
            return;
        }
        if(currDist == 0){
            goRight = true;
        }

        if(goRight){
            helper(root.left, reqDist, currDist+1, goRight);
            helper(root.right, reqDist, currDist+1, goRight);
        }
        else{
            helper(root.left, reqDist, currDist-1, goRight);
            helper(root.right, reqDist, currDist-1, goRight);
        }

    }

    private static int dist(Node root, int target, int k){
        if(root == null)
            return -1;
        if(root.data == target) {
            return k;
        }

        int ans = dist(root.left, target, k+1);

        if (ans == -1)
            return dist(root.right, target, k+1);
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(12);
        root.right = new Node(13);

        root.left.left = new Node(1);
        root.left.right = new Node(5);
        root.right.left = new Node(20);
        root.right.right = new Node(10);

        root.left.right.left = new Node(7);
        root.left.right.right = new Node(16);
        root.right.right.left = new Node(17);
        root.right.right.right = new Node(8);

        root.left.right.right.left = new Node(19);
        root.left.right.right.right = new Node(3);

        System.out.println(KDistanceNodes(root, 8, 1));
    }
}
