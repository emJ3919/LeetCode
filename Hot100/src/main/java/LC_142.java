public class LC_142 {
    public ListNode detectCycle(ListNode head) {
        //确定环
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        //标志位记录是否有环
        int flag = 0;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                flag = 1;
                break;
            }
        }
        // 不存在环
        if(flag == 0){
            return null;
        }
        // 慢指针放回head，相同速度跑，相遇的地方就是环入口
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
