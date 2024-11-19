import java.util.List;

public class ReverseLLII92 {
    public static void main(String[] args) {
         ListNode a = new ListNode(1);
         ListNode b = new ListNode(2, a);
         ListNode c = new ListNode(3, b);
         ListNode d = new ListNode(4, c);
         ListNode e = new ListNode(5, d);

         ListNode head = reverseBetween(e, 1, 5);
         int i = 0;
         while(head != null && i < 10){
             System.out.print(head.val + " -> ");
             head = head.next;
             i++;
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
    public static ListNode reverseBetween(ListNode head, int left, int right){
//        this implies if the LL is empty or has one element only or left == right
        if(head == null || head.next == null || left == right){
            return head;
        }
        return revBetween(head, left, right);
    }
    public static ListNode revBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;

        ListNode leftNode = null;
        ListNode leftOfLeftNode = null;

//        for(int i = 1; pres != null && i <= right; i++){
        for(int i = 1;  pres != null && i <= right; i++){
            if(i == left)
                leftNode = pres;
            else if(i == left - 1)
                leftOfLeftNode = pres;

            if(i > left && i <= right){
                pres.next = prev;
            }

            prev = pres;
            pres = next;
            if(next != null){
                 next = next.next;
            }
        }
        if(leftOfLeftNode != null){
            leftOfLeftNode.next = prev;
        }
        else
            head = prev;

//        pres is the node to the right of the node on the 'right' index
        leftNode.next = pres;
        return head;

    }
}
