public class FlattenAMultilevelDLL430 {
    static class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    Node(int v){
        this.val = v;
    }
    Node(){

    }
};

    public static void main(String[] args) {
        Node head = new Node(1);
        Node h = head;
        head.next = new Node(2);
        head = head.next;
        head.next = new Node(3);
        head = head.next;

        head.child = new Node(7);
        Node temp = head.child;
        temp.next = new Node(8);
        temp = temp.next;
        temp.child = new Node(11);

        Node temp2 = temp.child;
        temp2.next = new Node(12);

        temp.next = new Node(9);
        temp = temp.next;
        temp.next = new Node(10);

        head.next = new Node(4);
        head = head.next;
        head.next = new Node(5);
        head = head.next;
        head.next = new Node(6);
        head = head.next;

        flatten(h);

        while(h != null){
            System.out.print(h.val + " -> ");
            h = h.next;
        }
        System.out.println("END");

    }
    public static Node flatten(Node head){
        return func(head, null);
    }

    private static Node func(Node head, Node prev){
        if(head == null){
            return prev;
        }

        if(head.child != null){
            Node temp = head.next;
            head.next = head.child;
            head.child.prev = head;

            head.child = null;
            Node a = func(head.next, head);
            a.next = temp;
            temp.prev = a;
        }
        return func(head.next, head);
    }
}
