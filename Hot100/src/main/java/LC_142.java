/**
 * 题目：环形链表 II
 * 思路：快慢指针 + 数学证明。
 * 第一步：快慢指针确定是否有环，慢指针走一步，快指针走两步，若相遇则有环。
 * 第二步：慢指针放回头节点，两指针以相同速度继续走，相遇点即为环入口。
假设：第一次相遇时头节点到入口距离为a，入口到相遇点距离为b，相遇点跑到入口距离为c。
2(a + b) = a + n(b + c) + b -> a = (n - 1)(b + c) + c
所以，从入口到相遇点的距离 = 跑n-1圈 + 到入口的距离
 * 说明从头到入口的距离等于从相遇点到入口的距离，两者一定会相遇。
 * 时间复杂度：O(n)，空间复杂度：O(1)。
 */
public class LC_142 {
    public ListNode detectCycle(ListNode head) {
        //确定环
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        //标志位记录是否有环
        int flag = 0;
        // 快慢指针找环
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
        // 慢指针放回head，以相同速度跑，相遇的地方就是环入口
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
