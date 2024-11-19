public class CLL {

    private Node head;

    public void insertFirst(int value){
        Node node = new Node(value, head);
        if(head == null){
            head = node;
            head.next = head;
            return;
        }
        getLast().next = node;
        head = node;
    }

    private Node getLast(){
       Node temp = head;
        while(temp.next != head)
            temp = temp.next;
        return temp;
    }

    public void display(){
        Node temp = head;
        if(temp == null){
            System.out.println("null");
            return;
        }
        while(temp.next != head){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print(temp.value + " -> ");
        System.out.println("END");
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
