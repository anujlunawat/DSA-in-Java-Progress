public class LLCycle141 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while(f != null && f.next != null){
            f = f.next.next;
            s = s.next;
            int length;

            if(f == s){
                length = cycleLength(s);
            }
        }
        return false;
    }

//    length of cycle
    public int cycleLength(ListNode node){
        ListNode f = node;
        int length = 1;
        do{
            length++;
            f = f.next;
        }while(f != node);
        return length;
    }
}
