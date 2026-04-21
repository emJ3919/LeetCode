/**
 * 题目：两两交换链表中的节点
 * 思路：模拟交换过程。
 * 使用虚拟头节点简化边界处理，遍历链表每次交换相邻的两个节点。
 * 交换后用tail指针维护已交换部分的尾节点，接上后续未交换的部分。
 * 时间复杂度：O(n)，空间复杂度：O(1)。
 */
public class LC_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        // 节点大于等于两个进行交换
        ListNode prev = head;
        ListNode cur = prev.next;
        // 结果链表的头节点
        ListNode dummy = new ListNode(0);
        dummy.next = cur;
        // 交换好的链表的尾指针
        ListNode tail = null;
        while (true){
            // 交换节点
            prev.next = cur.next;
            cur.next = prev;
            // 接上前面交换好的链表
            if(tail != null){
                tail.next = cur;
            }
            // tail变为交换好部分的尾节点，prev现在在cur后面
            tail = prev;
            if(prev.next == null || prev.next.next == null){
                break;
            }
            prev = prev.next;
            cur = prev.next;
        }
        // 不能直接返回原来的头节点，因已经是第二位了。
        return dummy.next;
    }
}
