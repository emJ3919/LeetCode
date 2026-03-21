public class LC_234 {
    public boolean isPalindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        //快慢指针找第二段的起始位置
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //如果快指针没走到最后一个元素，说明是奇数个节点，且慢指针刚好停在中间那个节点
        if(fast.next != null){
            //将慢指针后移一个到需要反转的开始位置
            slow = slow.next;
        }
        //反转第二段，将第二段反转后遍历比较。
        ListNode prev = null;
        ListNode cur = slow;
        ListNode next;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        //比较前后两段：前是head开始，后是prev开始。
        fast = head;
        while (prev != null){
            if(fast.val != prev.val){
                return false;
            }
            prev = prev.next;
            fast = fast.next;
        }
        return true;
    }
}
