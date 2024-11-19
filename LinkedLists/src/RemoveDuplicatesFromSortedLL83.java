public class RemoveDuplicatesFromSortedLL83 {
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

    public ListNode deleteDuplicates(ListNode head) {
        if(head.next == null)
            return head;
        if(head.val == head.next.val){
            head.next = head.next.next;
            return deleteDuplicates(head);
        }
        deleteDuplicates(head.next);
        return head;
    }
}
