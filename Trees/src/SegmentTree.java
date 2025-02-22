import com.sun.source.tree.Tree;

public class SegmentTree {
    private static class Node{
        int data;
        Node left;
        Node right;
        int startInterval;
        int endInterval;

        Node(int data){
            this.data = data;
        }
        Node(int data, int startInterval, int endInterval){
            this.data = data;
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
        Node(int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
        Node(){

        }
    }

    private Node root;

    SegmentTree(int[] arr) {
       this.root = insert(arr, 0, arr.length - 1);
   }
   private Node insert(int[] arr, int s, int e){
        Node node = new Node(s, e);

        if(s == e){
            node.data = arr[s];
            return node;
        }

        int mid = s + (e - s) / 2;
        node.left = insert(arr, s, mid);
        node.right = insert(arr, mid+1, e);
        node.data = node.left.data + node.right.data;
        return node;
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
            System.out.println("|------->" + node.data);
        }
        else{
            System.out.println(node.data);
        }
        prettyPrint(node.left, level + 1);
    }

    public int query(int qsi, int qei){
        return query(root, qsi, qei);
    }
    private int query(Node node, int start, int end){
//        no overlapping
        if(node.startInterval > end || node.endInterval < start)
            return 0;
//        node interval inside query interval
        if(node.startInterval >= start && node.endInterval <= end){
                return node.data;
        }

        return query(node.left, start, end) + query(node.right, start, end);

    }

    public void update(int index, int value){
        update(root, index, value);
    }
    private void update(Node node, int index, int value){
        if(node.startInterval <= index && node.endInterval >= index){
            if(node.startInterval == index && node.endInterval == index){
                node.data = value;
                return;
            }
            int mid = (node.startInterval + node.endInterval) / 2;

            if(index <= mid)
                update(node.left, index, value);
            else update(node.right, index, value);
            node.data = node.left.data + node.right.data;
        }

    }

    public static void main(String[] args) {
    int[] arr = {3, 8, 7, 6, -2, -8, 4, 9};
    SegmentTree tree = new SegmentTree(arr);

    // Test Case 1: Full array sum
    System.out.println("Query(0,7): " + tree.query(0, 7)); // Expected: 27

    // Test Case 2: Query a subarray
    System.out.println("Query(2,5): " + tree.query(2, 5)); // Expected: 3 (7+6-2-8)

    // Test Case 3: Update an element and re-query
    tree.update(3, 10); // Change index 3 (value 6 -> 10)
    System.out.println("After update(3,10), Query(0,7): " + tree.query(0, 7)); // Expected: 31

    // Test Case 4: Query a single element
    System.out.println("Query(3,3): " + tree.query(3, 3)); // Expected: 10

    // Test Case 5: Query non-overlapping range (should return 0)
    System.out.println("Query(10,12): " + tree.query(10, 12)); // Expected: 0 (out of bounds)

    // Test Case 6: Querying the first half
    System.out.println("Query(0,3): " + tree.query(0, 3)); // Expected: 3+8+7+10 = 28

    // Test Case 7: Querying the second half
    System.out.println("Query(4,7): " + tree.query(4, 7)); // Expected: -2 -8 + 4 + 9 = 3

    // Test Case 8: Updating a negative value
    tree.update(5, -5); // Changing index 5 from -8 to -5
    System.out.println("After update(5,-5), Query(4,7): " + tree.query(4, 7)); // Expected: 6

    // Test Case 9: Updating an index out of bounds (should be handled)
    try {
        tree.update(10, 15);
    } catch (Exception e) {
        System.out.println("Caught exception for out-of-bounds update: " + e.getMessage());
    }

    // Test Case 10: Querying a partially overlapping range
    System.out.println("Query(2,6): " + tree.query(2, 6)); // Expected: 7 + 10 -2 -5 + 4 = 14
}

}
