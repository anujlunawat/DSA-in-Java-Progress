public class Add2Nums2 {
    public static class ListNode {
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

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode head = ans;
        int carry = 0;
        while(l1 != null || l2 != null){
            ListNode temp = new ListNode();
            int v = carry;
            if(l1 != null) {
                v += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                v += l2.val;
                l2 = l2.next;
            }
            temp.val = v % 10;
            carry = v / 10;
            ans.next = temp;
            ans = ans.next;
        }


//        while(temp != null){
//            ListNode t = new ListNode();
//            int v = temp.val + carry;
//            t.val = v % 10;
//            carry = v / 10;
//            ans.next = t;
//            ans = ans.next;
//            temp = temp.next;
//        }

        if(carry != 0){
            ans.next = new ListNode (carry);
        }


        return head.next;
    }

    private void add(ListNode l1, ListNode l2, ListNode head, int carry){
        if(l1 == null && l2 == null) {
            if(carry != 0)
                head.next = new ListNode(carry);
            return;
        }
        int v = carry;

        if(l1 != null) {
            v += l1.val;
            l1 = l1.next;
        }
        if(l2 != null) {
            v += l2.val;
            l2 = l2.next;
        }
        head.next = new ListNode(v % 10);
        add(l1, l2, head.next, v / 10);
    }
}
