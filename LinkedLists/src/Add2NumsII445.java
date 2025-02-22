import java.util.List;

public class Add2NumsII445 {
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
        ListNode l1 = new ListNode(7);
        ListNode head1 = l1;
        l1.next = new ListNode(2);
        l1 = l1.next;
        l1.next = new ListNode(4);
        l1 = l1.next;
        l1.next = new ListNode(3);

        ListNode l2= new ListNode(5);
        ListNode head2 = l2;
        l2.next = new ListNode(6);
        l2 = l2.next;
        l2.next = new ListNode(4);

        ListNode head = addTwoNumbers(head1, head2);

        while(head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("END");

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        l1 = reverse(l1, null);
        l2 = reverse(l2, null);

//        ListNode head = l1;
//        while(head != null){
//            System.out.print(head.val + " -> ");
//            head = head.next;
//        }
//        System.out.println("END");

//        head = l2;
//        while(head != null){
//            System.out.print(head.val + " -> ");
//            head = head.next;
//        }
//        System.out.println("END");


        add(l1, l2, ans, 0);
//
//        head = ans;
//        while(head != null){
//            System.out.print(head.val + " -> ");
//            head = head.next;
//        }
//        System.out.println("END");
        ans = reverse(ans.next, null);
        return ans;
    }

    private static void add(ListNode l1, ListNode l2, ListNode head, int carry){
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

    private static ListNode reverse(ListNode node, ListNode prev){
       if(node == null){
           return prev;
       }
       ListNode temp = node.next;
       node.next = prev;
       return reverse(temp, node);
    }
}
