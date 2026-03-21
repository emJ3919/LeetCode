public class LC_206 {
    public ListNode reverseList(ListNode head){
        ListNode tmpHead = new ListNode(0);
        while(head != null){
            ListNode next = head.next;
            head.next = tmpHead.next;
            tmpHead.next = head;
            head = next;
        }
        return tmpHead.next;
    }
    public ListNode solution2(ListNode head){
        ListNode new_head = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null){
            next = cur.next;
            cur.next = new_head;
            new_head = cur;
            cur = next;
        }
        return new_head;
    }
}
