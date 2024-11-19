import java.util.List;

public class ReverseLL206 {
     public static void main(String[] args) {
         ListNode a = new ListNode(1);
         ListNode b = new ListNode(2, a);
         ListNode c = new ListNode(3, b);
         ListNode d = new ListNode(4, c);
         ListNode e = new ListNode(5, d);

         ListNode head = reverseList(null, e);
         while(head != null){
             System.out.print(
                     head.val + " -> ");
             head = head.next;
         }
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
    private static ListNode reverseList(ListNode node1, ListNode node2){
         if(node2.next == null){
             node2.next = node1;
             return node2;
         }

         ListNode node3 = node2.next;
         node2.next = node1;
         return reverseList(node2, node3);
     }
//    private static ListNode reverseList(ListNode node1, ListNode node2, ListNode node3){
//         if(node3 == null){
//             node2.next = node1;
//             return node2;
//         }
//
//         node3 = node2.next;
//         node2.next = node1;
//         return reverseList(node2, node3, node3.next);
//     }

//    private static ListNode reverseList(ListNode node1, ListNode node2){
//         if(node2 == null){
//             return node1;
//         }
//        ListNode head = reverseList(node1.next, node2.next);
//
//         node2.next = node1;
//         node1.next = null;
//
//         return head;
//    }


}
