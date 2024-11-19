import org.w3c.dom.Node;

public class Merge2SortedLists21 {
     public class ListNode {
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

//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode tail = null;
//        ListNode head = null;
//
//        while(l1 != null && l2 != null){
//            if (l1.val < l2.val){
//                if(head == null){
//                    head = new ListNode(l1.val);
//                    tail = head;
//                }
//                else{
//                    tail.next = new ListNode(l1.val);
//                    tail = tail.next;
//                }
//                l1 = l1.next;
//            }
//
//            else{
//                if(head == null){
//                    head = new ListNode(l2.val);
//                    tail = head;
//                }
//                else{
//                    tail.next = new ListNode(l2.val);
//                    tail = tail.next;
//                }
//                l2 = l2.next;
//            }
//        }
//
//        while(l1 != null){
//            if(head == null){
//                    head = new ListNode(l1.val);
//                    tail = head;
//                }
//                else{
//                    tail.next = new ListNode(l1.val);
//                    tail = tail.next;
//                }
//                l1 = l1.next;
//        }
//
//        while(l2 != null){
//            if(head == null){
//                    head = new ListNode(l2.val);
//                    tail = head;
//                }
//                else{
//                    tail.next = new ListNode(l2.val);
//                    tail = tail.next;
//                }
//                l2 = l2.next;
//        }
//
//        return head;
//    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode tail = null;
        ListNode node = new ListNode();

        if(l1 == null && l2 == null){
            return null;
        }

        if(l1 != null) {
            if (l2 != null) {
                if (l1.val < l2.val) {
                    node.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
                else{
                    node.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }
            else{
                node.next = new ListNode(l1.val);
                l1 = l1.next;
            }
        }
        else{
            node.next = new ListNode(l2.val);
            l2 = l2.next;
        }
        mergeTwoLists(l1, l2);
        return node;
    }
}
