public class LC_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        // 节点大于等于两个进行交换
        ListNode prev = head;
        ListNode cur = prev.next;
        // 为后面返回做准备
        ListNode dumpy = new ListNode(0);
        dumpy.next = cur;
        // 交换好的链表的尾指针
        ListNode tail = null;
        while (true){
            prev.next = cur.next;
            cur.next = prev;
            if(tail != null){
                tail.next = cur;
            }
            // 前面交换好的连上
            tail = prev;
            if(prev.next == null || prev.next.next == null){
                break;
            }
            prev = prev.next;
            cur = prev.next;
        }
        // 不能直接返回原来的头节点，因已经是第二位了。
        return dumpy.next;
    }
}
