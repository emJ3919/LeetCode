/**
 * 题目：颜色分类
 * 思路：三指针（荷兰国旗问题）。
 * 用两个指针分别记录0的右边界和2的左边界，遍历数组。
 * 遇到0则与0的右边界交换，指针右移；遇到2则与2的左边界交换，指针左移（当前不右移因为换回来的需要再判断）。
 * 遇到1则指针右移。
 * 时间复杂度：O(n)，空间复杂度：O(1)。
 */
public class LC_75 {
    public void sortColors(int[] nums) {
        int p0 = 0; // 0的右边界:下一个0的位置
        // 2的左边界：下一个2的位置，从右往左移动
        int p2 = nums.length - 1; 
        int cur = 0; // 当前遍历的位置
        // 遍历直到当前遇到2，说明排序完成
        while (cur <= p2){
            if (nums[cur] == 0){ // 0放在p0并更新p0
                // 交换
                int tmp = nums[cur];
                nums[cur] = nums[p0];
                nums[p0] = tmp;
                // 移动
                p0++;
                cur++;
            }else if (nums[cur] == 2){ // 2放在p2
                int tmp = nums[cur];
                nums[cur] = nums[p2];
                nums[p2] = tmp;
                // 这里cur不能动，因为换回来的是没判断过的。
                p2--;
            } else { // 1不用操作
                cur++;
            }
        }
    }
}
