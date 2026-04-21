/**
 * 题目：合并两个有序链表
 * 思路：虚拟头节点。
 * 建立虚拟头节点，同时遍历两个链表，每次取较小节点接到结果链表后面。
 * 遍历完其中一个链表后，将另一个链表剩余部分直接接上。
 * 时间复杂度：O(m+n)，空间复杂度：O(1)。
 */
public class LC_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        // 初始化临时节点
        ListNode tmp_head = new ListNode(0);
        //临时节点的尾
        ListNode cur = tmp_head;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        // 遍历cur1 cur2 小的接在临时节点后面
        while (cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }else {
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }
        // 接上未遍历完的链表
        if(cur1 != null){
            cur.next = cur1;
        }else {
            cur.next = cur2;
        }
        return tmp_head.next;
    }
}
