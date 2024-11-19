public class MiddleOfLL876 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

//    approach 1
    public ListNode middleNode(ListNode head) {
        int length = listLength(head);
        length /= 2;
        while(length > 0){
            head = head.next;
            length--;
        }
        return head;
    }

    public int listLength(ListNode head){
        int length = 0;
        while(head != null){
            head = head.next;
            length++;
        }
        return length;
    }

//    approach 2
    public ListNode middleNode2(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
