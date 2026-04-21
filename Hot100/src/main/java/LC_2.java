/**
 * 题目：两数相加
 * 思路：模拟逐位相加。
 * 从低位到高位遍历两个链表，每位相加加上进位，取个位写入结果，十位作为进位。
 * 循环条件：l1没遍历完 或 l2没遍历完 或 进位不为0。
 * 时间复杂度：O(max(m,n))，空间复杂度：O(1)。
 */
public class LC_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
            // 要判断是否为空，否则会报错
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
        }
        return ans.next;
    }

    // public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //     // 初始化结果数组 个位为0
    //     ListNode ans = new ListNode(0);
    //     ListNode cur = ans;
    //     // 计算结果的临时指针
    //     ListNode tmp_cur;
    //     // 记录当前位置合
    //     int sum;
    //     // 记录进位数
    //     int next_plus;
    //     // 记录非进位数
    //     int plus;
    //     while (l1 != null || l2 != null){
    //         int x = l1 == null? 0 : l1.val;
    //         int y = l2 == null? 0 : l2.val;
    //         sum = x + y + cur.val;
    //         plus = sum % 10;
    //         next_plus = sum / 10;
    //         cur.val = plus;
    //         // 需要进位
    //         tmp_cur = cur;
    //         while (next_plus != 0){
    //             if(tmp_cur.next == null){
    //                 tmp_cur.next = new ListNode(0);
    //                 tmp_cur = tmp_cur.next;
    //             }
    //             sum = next_plus + tmp_cur.val;
    //             plus = sum % 10;
    //             tmp_cur.val = plus;
    //             next_plus = sum / 10;
    //         }
    //         if (l1 != null) {
    //             l1 = l1.next;
    //         }
    //         if (l2 != null) {
    //             l2 = l2.next;
    //         }
    //         if (cur.next != null){
    //             cur = cur.next;
    //         }else if (l1 == null && l2 == null) {
    //             break;
    //         }else {
    //             cur.next = new ListNode(0);
    //             cur = cur.next;
    //         }
    //     }
    //     return ans;
    // }
}
