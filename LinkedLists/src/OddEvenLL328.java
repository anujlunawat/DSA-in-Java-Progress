public class OddEvenLL328 {
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

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode node = head.next;
        helper(head, head.next).next = node;

        return head;
    }

    private ListNode helper(ListNode head1, ListNode head2){
        if(head2 == null)
            return head1;

        head1.next = head2.next;
        if(head1.next != null)
            head2.next = head1.next.next;
        else return head1;

        return helper(head1.next, head2.next);
    }
}
