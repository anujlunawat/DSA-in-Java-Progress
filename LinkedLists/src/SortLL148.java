public class SortLL148 {
    public static void main(String[] args) {
//        ListNode a = new ListNode(0);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4, b);
        ListNode d = new ListNode(5, c);
        ListNode e = new ListNode(-1, d);

        sortList(e);

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode sortList(ListNode head){
        return sort(head, null);
    }

    public static ListNode sort(ListNode head, ListNode tail){
        if(head == tail){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast == slow)
            fast = slow.next;
        ListNode lefthead = sort(head, slow);
        ListNode righthead = sort(slow.next, fast);

        return mergeSort(lefthead, slow, righthead, fast);
    }

    static ListNode mergeSort(ListNode start1, ListNode end1, ListNode start2, ListNode end2){
        ListNode head = new ListNode();
        ListNode h = head;

        while(start1 != end1 && start2 != end2){
            if(start1.val < start2.val){
                head.next = new ListNode(start1.val);
                start1 = start1.next;
            }
            else{
                head.next = new ListNode(start2.val);
                start2 = start2.next;
            }
            head = head.next;
        }

        while(start1 != end1 && start1 != null){
            head.next = new ListNode(start1.val);
            start1 = start1.next;
            head = head.next;
        }

        while(start2 != end2 && start2 != null){
            head.next = new ListNode(start2.val);
            start2 = start2.next;
            head = head.next;
        }
        head = h.next;
        while(head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println();
        return h.next;
    }

}
