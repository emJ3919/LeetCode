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
