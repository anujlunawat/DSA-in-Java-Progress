import java.util.Arrays;
import java.util.List;

public class SplitLLInParts725 {
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

    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        if(head == null || k == 0)
            return ans;

        int len = size(head);
        int rem = len % k;

        for(int i = 0; i < k && head != null; i++){
            ans[i] = head;
            for(int j = 1; j < len / k; j++)
                head = head.next;

            if(rem-- > 0 && k < len){
                head = head.next;
                // rem--;
            }
            ListNode temp = head.next;
            head.next = null;
            head = temp;
        }
        return ans;
    }

    private static int size(ListNode head){
        int i = 0;
        while(head != null){
            head = head.next;
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h1 = head;
        for(int i = 2; i <=10; i++){
            h1.next = new ListNode(i);
            h1 = h1.next;
        }
        ListNode[] ans = splitListToParts(head, 3);
        for(ListNode a: ans){
            if(a!=null)
                System.out.print(a.val + " ");
            else
                System.out.print(a + " ");
        }
    }
}
