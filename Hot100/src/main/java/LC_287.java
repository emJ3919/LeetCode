/**
 * 题目：寻找重复数
 * 思路：快慢指针（转换为环形链表找入口）。
 * 将数组下标理解为指针，数组值理解为指向下一个位置的链表。
 * 由于存在重复数字，一定存在环，快慢指针一定会相遇。
 * 相遇后将慢指针重置为起点，两指针同速前进，再次相遇点即为环的入口，即重复数字。
 * 时间复杂度：O(n)，空间复杂度：O(1)。
 */
public class LC_287 {
    public int findDuplicate(int[] nums) {
        // 手动执行第一次移动
        int slow = nums[0];
        int fast = nums[nums[0]];
        // 快慢指针、找到环的入口
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 重置慢指针，从头开始遍历，找到环的入口
        // 该入口即为重复元素
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        } 
        return slow;
    }
}