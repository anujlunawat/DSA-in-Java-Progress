public class LLCycleII142 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

//    length of cycle
    public int cycleLength(ListNode node){
        ListNode f = node;
        int length = 0;
        do{
            length++;
            f = f.next;
        }while(f != node);
        return length;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int length = 0;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                length = cycleLength(slow);
                break;
            }
        }
        if(length == 0)
            return null;

//        when you know the length of the cycle is 'length'
//        then you give a head start to a pointer by length nodes.
//        so that the distance between the two pointers is length.
//        then, the two can meet at the start of the cycle when one has just finished traversing the cycle and he meets the other who just came there, at the head of the cycle.
        ListNode f = head;
        ListNode s = head;
        while(length > 0){
            f = f.next;
            length--;
        }
        while(f != s){
            f = f.next;
            s = s.next;
        }
        return f;
    }
}
