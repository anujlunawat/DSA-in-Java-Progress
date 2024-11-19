import java.util.List;

public class PalindromeLL234 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2, a);
//        ListNode c = new ListNode(4, b);
//        ListNode d = new ListNode(4, c);
//        ListNode e = new ListNode(0, d);
//        ListNode f = new ListNode(1, e);
//        ListNode g = new ListNode(4, c);
//        ListNode e = new ListNode(5, d);

        System.out.println(isPalindrome(b));
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

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return false;

        ListNode head2 = createLL(head);
        return isPalindrome(head, head2);
    }

//    private static boolean isPalindrome(ListNode head, ListNode node1, ListNode node2, int length, int l){
//        if(node1 == node2){
//            return true;
//        }
//        if(node1.next == node2){
//            if(node1.val == node2.val)
//                return true;
//            return false;
//        }
//
//        if(node1.val == node2.val){
//            return isPalindrome(head, node1.next, findNode(head, l+1, length), length, l+1);
//        }
//        return false;
//    }
//
//    private static ListNode findNode(ListNode head, int l, int length){
//        while(length - 1 - l > 0) {
//            head = head.next;
//            l++;
//        }
//        return head;
//    }

    private static boolean isPalindrome(ListNode head1, ListNode head2){
        if(head1 == null || head2 == null){
            return true;
        }

        if(head1.val != head2.val)
            return false;

        return isPalindrome(head1.next, head2.next);
    }

    private static ListNode createLL(ListNode head){
        ListNode s = head;
        ListNode f = head;
        ListNode prev = null;
        ListNode lastNode = null;

        while(f != null && f.next != null){
            prev = prev == null ? s : prev.next;
            s = s.next;
            f = f.next.next;
        }
        if(s.next != null){
//            the last element is the start of the new reversed list
            lastNode = reverseLL(s, s.next, s.next.next);
        }

        else{
            lastNode = s;
        }
        prev.next =  null;
        s.next = null;
        return lastNode;
    }

//    reverse half of the LL, from the middle
    private static ListNode reverseLL(ListNode prev, ListNode pres, ListNode next){
        if(next == null){
            pres.next = prev;
//            prev.next = null;
            return pres;
        }

        pres.next = prev;
//        prev.next = null;
        return reverseLL(pres, next, next.next);
    }
//    private static boolean isPalindrome(ListNode head1, ListNode head2, ListNode midhead){
//        if(head1 == null || head1 == midhead || head2 == null){
//            return true;
//        }
//
//        if(head1.val != head2.val)
//            return false;
//
//        return isPalindrome(head1.next, head2.next, midhead);
//    }
//
//    private static ListNode createLL(ListNode head){
//        ListNode s = head;
//        ListNode f = head;
//        ListNode prev = null;
//
//        while(f != null && f.next != null){
//            prev = prev == null ? s : prev.next;
//            s = s.next;
//            f = f.next.next;
//        }
//        if(s.next != null){
//            prev.next =  reverseLL(s, s.next, s.next.next);
//            s.next = null;
//        }
//        return prev.next;
//    }
//
////    reverse half of the LL, from the middle
//    private static ListNode reverseLL(ListNode prev, ListNode pres, ListNode next){
//        if(next == null){
//            pres.next = prev;
////            prev.next = null;
//            return pres;
//        }
//
//        pres.next = prev;
////        prev.next = null;
//        return reverseLL(pres, next, next.next);
//    }
}
