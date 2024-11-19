public class ReverseNodesInkGroup25 {
    public static void main(String[] args) {
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(4, a);
        ListNode c = new ListNode(3, b);
        ListNode d = new ListNode(2, c);
        ListNode e = new ListNode(1, d);

//        ListNode head = reverseBetween(null, e, e.next, 2);
//        while(head != null){
//            System.out.print(head.val + " -> ");
//            head = head.next;
//        }
//        System.out.println("END");

//        ListNode head = reverseKGroup(e, 2);
//        reverseBetween(null, e, e.next, 2);
        ListNode var = reverseKGroup(e, 1);
        while(var != null){
            System.out.print(var.val + " -> ");
            var = var.next;
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



//    private static ListNode reverseBetween(ListNode prev, ListNode pres, ListNode next, int k, boolean isFirst, ListNode firstNode){
//        if(k == 0){
//            System.out.println(prev.val);
//            System.out.println(pres.val);
//            System.out.println(next.val);
//            return firstNode;
//        }
//
//        if(isFirst){
//            firstNode = pres;
//            isFirst = false;
//        }
//        next = pres.next;
//        pres.next = prev;
//        return reverseBetween(pres, next, next.next, k - 1, isFirst, firstNode) ;
//    }

public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;

        ListNode temp = head;
        int len = 0;
        while(temp != null){
            temp = temp.next;
            len++;
        }
// point at the last node of a reversed subList
        ListNode ptr = null;
//        left End of the LL
        ListNode leftEnd = null;
//        temporary head
        ListNode tempHead = head;

        while(len - k >= 0){
//            this should be the end of the reversed LL
            ListNode rightEnd = tempHead;
            for(int t = k; t > 0 && tempHead.next != null; t--){
                tempHead = tempHead.next;
            }
//            this is the start of the new reversed LL
            leftEnd = reverseBetween(rightEnd, rightEnd.next, k);


            if(ptr != null){
                ptr.next = leftEnd;
            }
            else{
                head = leftEnd;
            }
            ptr = rightEnd;
            len -= k;
        }

        if(len > 0)
            ptr.next = tempHead;
        else
            ptr.next = null;

        return head;
    }

    private static ListNode reverseBetween(ListNode prev, ListNode pres, int k){
        if(k == 1){
            return prev;
        }

        ListNode next = pres.next;
        pres.next = prev;
        return reverseBetween(pres, next, k - 1) ;
    }
}