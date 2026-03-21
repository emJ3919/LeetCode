public class LC_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        if (head == null){
            return null;
        }
        int len = 0;
        while (cur != null){
            len ++;
            cur = cur.next;
        }
        n = len - n;
        if (n == 0){
            return head.next;
        }
        ListNode prev = head;
        cur = head.next;
        len = 1;
        while (cur != null){
            if(len == n){
                prev.next = cur.next;
                cur.next = null;
            }
            cur = cur.next;
            len++;
            prev = prev.next;
        }
        return head;
    }
}
