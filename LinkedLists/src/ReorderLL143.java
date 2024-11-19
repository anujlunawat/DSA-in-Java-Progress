import java.util.List;

public class ReorderLL143 {
    public static void main(String[] args) {
         ListNode a = new ListNode(5);
         ListNode b = new ListNode(4, a);
         ListNode c = new ListNode(3, b);
         ListNode d = new ListNode(2, c);
         ListNode e = new ListNode(1, d);

         reorderList(e);
         while(e != null){
             System.out.print(e.val + " -> ");
             e = e.next;
         }
        System.out.println("END");
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;

        ListNode head2 = createLL(head);
        reorderList(head, head2);
    }

    private static void reorderList(ListNode head1, ListNode head2){
        if(head1.next == null){
            head1.next = head2;
            return;
        }
        ListNode next1 = head1.next;
        head1.next = head2;

        ListNode next2 = head2.next;
        head2.next = next1;
        reorderList(next1, next2);
    }
//    private static void reorderList(ListNode node, ListNode head1, ListNode head2){
//        if(head1 == null){
//            if(head2 == null)
//                return;
//            node.next = head2;
//            return;
//        }
//
//        node.next = new ListNode(head2.val);
//        node = node.next;
//        node.next = new ListNode(head1.val);
//        reorderList(node.next, head1.next, head2.next);
//    }

    private static ListNode createLL(ListNode head){
        ListNode s = head;
        ListNode f = head;
        ListNode prev = null;
        ListNode lastNode = null;

        while(f != null && f.next != null){
            prev = prev == null ? s : prev.next;
            s = s.next;
            f = f.next.next;
        }
        if(s.next != null){
//            the last element is the start of the new reversed list
            lastNode = reverseLL(s, s.next, s.next.next);
        }

        else{
            lastNode = s;
        }
        prev.next =  null;
        s.next = null;
        return lastNode;
    }

    private static ListNode reverseLL(ListNode prev, ListNode pres, ListNode next){
        if(next == null){
            pres.next = prev;
//            prev.next = null;
            return pres;
        }

        pres.next = prev;
//        prev.next = null;
        return reverseLL(pres, next, next.next);
    }
}
