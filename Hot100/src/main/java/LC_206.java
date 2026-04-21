/**
 * 题目：反转链表
 * 思路：
 * 方法1：头插法。
 * 建立虚拟头节点，将原链表节点依次取下，头插到新链表前面。
 * 时间复杂度：O(n)，空间复杂度：O(1)。
 * 方法2：原地反转。
 * 初始化一个新链表头为null，遍历原链表时依次取出节点，将其next指向前一个节点（新链表头），
 * 然后该节点成为新的链表头，直到原链表遍历完。
 * 时间复杂度：O(n)，空间复杂度：O(1)。
 */
public class LC_206 {
    // 头插法反转
    public ListNode reverseList1(ListNode head){
        // 临时头节点
        ListNode tmpHead = new ListNode(0);
        while(head != null){
            // 头插法
            ListNode next = head.next;
            head.next = tmpHead.next;
            tmpHead.next = head;
            head = next;
        }
        return tmpHead.next;
    }

    // 原地反转
    public ListNode reverseList2(ListNode head){
        // 存反转后的节点，初始化为null，因为反转后第一个节点指向null
        ListNode new_head = null;
        // 当前节点
        ListNode cur = head;
        // 下一个节点
        ListNode next;
        while (cur != null){
            // 保存下次要操作的节点
            next = cur.next;
            // 当前节点连接反转后的节点
            cur.next = new_head;
            // 自己变成下一个反转后被连接的节点
            new_head = cur;
            // 移动到下一个要操作的节点
            cur = next;
        }
        // 返回反转后的头节点
        return new_head;
    }
}
