public class LC_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 初始化结果数组 个位为0
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        // 计算结果的临时指针
        ListNode tmp_cur;
        // 记录当前位置合
        int sum;
        // 记录进位数
        int next_plus;
        // 记录非进位数
        int plus;
        while (l1 != null || l2 != null){
            int x = l1 == null? 0 : l1.val;
            int y = l2 == null? 0 : l2.val;
            sum = x + y + cur.val;
            plus = sum % 10;
            next_plus = sum / 10;
            cur.val = plus;
            // 需要进位
            tmp_cur = cur;
            while (next_plus != 0){
                if(tmp_cur.next == null){
                    tmp_cur.next = new ListNode(0);
                    tmp_cur = tmp_cur.next;
                }
                sum = next_plus + tmp_cur.val;
                plus = sum % 10;
                tmp_cur.val = plus;
                next_plus = sum / 10;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (cur.next != null){
                cur = cur.next;
            }else if (l1 == null && l2 == null) {
                break;
            }else {
                cur.next = new ListNode(0);
                cur = cur.next;
            }
        }
        return ans;
    }

    public ListNode solution2(ListNode l1, ListNode l2) {
        // 结果链表
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        // 进位数
        int carry = 0;
        // l1没计算完 || l2没计算完 || 进位没计算完
        while (l1 != null || l2 != null || carry != 0){
            int x = l1 == null? 0 : l1.val;
            int y = l2 == null? 0 : l2.val;
            int sum = x + y + carry;
            // 更新下一次进位
            carry = sum / 10;
            // 写入当前位计算结果
            cur.next = new ListNode(sum % 10);
            // 更新到下一位计算
            cur = cur.next;
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
        }
        return ans.next;
    }
}
