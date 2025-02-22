import com.sun.source.tree.Tree;

import java.util.*;

public class BTRightSideView199 {
    /**
 * Definition for a binary tree node.
 */
    public class TreeNode {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null)
            return ans;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int currentLevel = queue.size();
            ans.add(queue.peekLast().val);
            for(int i = 0; i < currentLevel; i++){
                TreeNode currentNode = queue.poll();
                if(currentNode.left != null)
                    queue.offer(currentNode.left);
                if(currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }
        return ans;
    }

}
