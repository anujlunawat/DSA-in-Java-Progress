import java.util.List;

public class MergeKSortedLists23 {
    public static void main(String[] args) {
        ListNode c  = new ListNode(33);
        ListNode b  = new ListNode(5, c);
        ListNode a  = new ListNode(1, b);

        ListNode k = new ListNode(32);
        ListNode j = new ListNode(11, k);
        ListNode i = new ListNode(4, j);

        ListNode[] lists = {a, i};

        ListNode head = mergeKLists(lists);

        while(head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("END");

    }

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

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        merge(lists, head);
        return head.next;
    }

    private static void merge(ListNode[] lists, ListNode head){
        ListNode lowest = null;
        int l = 0;
        for(int i = 0; i < lists.length; i++){
            if(lists[i] == null)
                continue;
            if(lowest == null || lowest.val > lists[i].val){
                lowest = lists[i];
                l = i;
            }
        }
        if(lowest != null) {
            lists[l] = lists[l].next;
            head.next = lowest;
            merge(lists, head.next);
        }
    }
}
