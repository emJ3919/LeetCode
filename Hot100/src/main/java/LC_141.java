/**
 * 题目：环形链表
 * 思路：快慢指针。
 * 慢指针每次走一步，快指针每次走两步，若链表有环，两者一定会相遇。
 * 快指针走到链表末尾则无环。
 * 时间复杂度：O(n)，空间复杂度：O(1)。
 */
public class LC_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        // 快慢指针找环
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，说明有环
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
