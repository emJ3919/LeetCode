/**
 * 题目：删除链表的倒数第 N 个结点
 * 思路：两遍遍历。
 * 第一遍遍历计算链表长度，计算要删除节点的正数位置（长度 - n）。
 * 第二遍遍历找到要删除节点的前驱节点，修改指针完成删除。
 * 注意：若删除的是第一个节点，直接返回头节点的下一个节点。
 * 时间复杂度：O(n)，空间复杂度：O(1)。
 */
public class LC_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        if (head == null){
            return null;
        }
        // 计算链表长度
        int len = 0;
        while (cur != null){
            len ++;
            cur = cur.next;
        }
        // 计算要删除的节点位置
        n = len - n;
        if (n == 0){
            return head.next;
        }
        // 记录前驱节点和当前节点的位置
        ListNode prev = head;
        cur = head.next;
        len = 1;
        // 遍历链表，找到要删除的节点
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
