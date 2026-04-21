/**
 * 题目：排序链表
 * 思路：归并排序。
 * 使用快慢指针找到链表的中点，将链表拆分为左右两部分。
 * 递归对左右两部分进行排序拆分，直到每部分只剩一个节点或为空。
 * 合并两个有序链表，返回排好序的链表。
 * 时间复杂度：O(n log n)，空间复杂度：O(log n)。
 */
public class LC_148 {
    public ListNode sortList(ListNode head) {
        // 判断是否到递归边界
        if (head == null || head.next == null){
            return head;
        }
        // 链表分为两部分
        ListNode slow = head;
        // 快指针要初始化在后一个位置，才能保证右半部分>=左半部分  1 2 3 4
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow 停的位置在中点或者左半部分
        ListNode left = head;
        ListNode right = slow.next;
        // 断开链表
        slow.next = null;
        // 递归左右两边，必须接住返回值
        left = sortList(left);
        right = sortList(right);
        // 排序合并
        return merge(left, right);
    }

    // 合并两个有序链表
    private ListNode merge(ListNode l1, ListNode l2){
        // 新建头节点合并
        ListNode tmp_head = new ListNode(0);
        ListNode tmp_cur = tmp_head;
        while ( l1 != null && l2 != null){
            if (l1.val <= l2.val){
                tmp_cur.next = l1;
                l1 = l1.next;
            }else {
                tmp_cur.next = l2;
                l2 = l2.next;
            }
            tmp_cur = tmp_cur.next;
        }
        if (l1 != null){
            tmp_cur.next = l1;
        }else if(l2 != null){
            tmp_cur.next = l2;
        }
        return tmp_head.next;
    }
}
