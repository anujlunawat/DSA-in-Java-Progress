public class LL {
    private Node head;
    private Node tail;
    private int size;

// Constructor
    public LL() {
        this.size = 0;
    }

//    method to insert at head
    public void insertFirst(int val){
        head = new Node(val, head);
        if (tail == null)
            tail = head;
        size += 1;
    }

//    method to insert at tail
    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        tail.next = new Node(val);
        tail = tail.next;
        size += 1;
    }

//    insert element at given pos
    public void insertAt(int val, int pos){
        if(pos == 0){
            insertFirst(val);
            return;
        }
        if(pos >= size){
            insertLast(val);
            return;
        }

        Node node = head;
        int p = 0;
        while(p < pos-1){
            node = node.next;
            p++;
        }

//        Node rightNode = node.next;
        node.next = new Node(val, node.next);
//        node.next.next = rightNode;
        size++;
    }

    public void insertAtRec(int val, int pos){
        if(pos == 0 || size == 0){
            head = new Node(val, head);
            size++;
            return;
        }

        if(pos == 1){
            Node node = new Node(val);
            node.next = head.next;
            head.next = node;
            if(node.next == null)
                tail = node;
            size++;
            return;
        }
        Node h = head;
        head = head.next;
        insertAtRec(val, pos-1);
        head = h;
    }

    public void insertAtRec2(int val, int pos){
//        insertForRec2(val, pos, head);
//        head = insertAtRec3(val, pos, head);
        insertAtRec4(val, pos, head);
    }

    private Node insertAtRec3(int val, int pos, Node node) {
        if(pos == 0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertAtRec3(val, pos-1, node.next);
        return node;
    }

    private void insertAtRec4(int val, int pos, Node node){
        if(pos == 0){
            head = new Node(val, head);
            size++;
            return;
        }
        if(pos == 1){
            node.next = new Node(val, node.next);
            size++;
            return;
        }
        insertAtRec4(val, pos-1, node.next);
    }

//    private void insertForRec2(int val, int pos, Node node){
//        if(pos == 0){
//            head = new Node(val, head);
//            if(tail == null)
//                tail = head;
//            size++;
//            return;
//        }
//
//        if(pos == 1){
//            Node n = new Node(val);
//            n.next = node.next;
//            node.next = n;
//            if(node == tail){
//                tail = n;
//            }
//            size++;
//            return;
//        }
//
//        if(pos > size-1){
//            tail.next = new Node(val);
//            return;
//        }
//
//        insertForRec2(val, pos-1, node.next);
//    }



    public void headTailValues(){
        System.out.println("head = " + head.value);
        System.out.println("tail = " + tail.value);
    }

//    method to display the linked list
    public void displayList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

//    delete the first node
    public int deleteFirst(){
        int value = head.value;
        head = head.next;

        if(head == null)
            tail = null;
        size--;
        return value;
    }

//    delete the last node
    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }
        Node temp = get(size-2);
        int value = tail.value;
        tail = temp;
        tail.next = null;
        size--;
        return value;
    }

//    delete the node at given position
    public int deleteAt(int pos){
        if(pos == 0){
            return deleteFirst();
        }
        if(pos >= size){
            return deleteLast();
        }

        Node node = get(pos-1);
        int value = node.next.value;
        node.next = node.next.next;
        size--;
        return value;
    }

    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

//    inner private class Node
    private class Node{
        private int value;
        private Node next;
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) {
            this.value = value;
        }
    }
    
    
    
    
//    questions

}
