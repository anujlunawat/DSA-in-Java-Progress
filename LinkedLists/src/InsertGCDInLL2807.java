public class InsertGCDInLL2807 {
    public static void main(String[] args) {
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(10, b);
        ListNode d = new ListNode(6, c);
        ListNode e = new ListNode(18, d);

        insertGreatestCommonDivisors(e);
        while (e != null){
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

//    public static ListNode insertGreatestCommonDivisors(ListNode head){
//        if(head == null || head.next == null)
//            return head;
//
//        ListNode first = head;
//        ListNode second = head.next;
//
//        while(second != null){
//            ListNode gcd = new ListNode(gcd(first.val, second.val));
//            gcd.next = second;
//            first.next = gcd;
//            first = second;
//            second = second.next;
//        }
//        return head;
//    }

    public static ListNode insertGreatestCommonDivisors(ListNode head){
        if(head == null || head.next == null)
            return head;


        ListNode gcd = new ListNode(gcd(head.val, head.next.val));
        gcd.next = head.next;
        head.next = gcd;

        insertGreatestCommonDivisors(gcd.next);
        return head;
    }

    private static int gcd(int i, int j){
        for(int n = Math.min(i, j); n > 0; n--){
            if(i % n == 0 && j % n == 0)
                return n;
        }
        return 1;
    }
}
