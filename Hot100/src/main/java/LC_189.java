/**
 * 题目：轮转数组
 * 思路：方法1用临时数组保存后k个元素，整体右移后放回。
 * 方法2（推荐）：用三次反转实现整体右移k位。
 * 三次反转：反转整个数组 -> 反转前k个 -> 反转剩余部分。
 * 原理：整体右移k位 等价于 数组末尾k个元素移动到开头，等价于三次翻转。
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class LC_189 {
    // 方法1：使用临时数组
    // 时间复杂度：O(n)，空间复杂度：O(k)，不建议使用
    public void solution1(int[] nums, int k){
        int len = nums.length;
        k = k % len;
        int[] tmp = new int[k];
        for (int i = len - k; i < len; i++){
            tmp[i - len + k] = nums[i];
        }
        for (int i = len - 1; i >= k; i--){
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++){
            nums[i] = tmp[i];
        }
    }
    // 方法2：使用反转数组
    // 时间复杂度：O(n)，空间复杂度：O(1)，建议使用
    public void solution2(int[] nums, int k){
        int len = nums.length;
        // 处理k大于数组长度的情况
        k = k % len;
        // 先反转整个数组
        reverse(nums, 0, len - 1);
        // 再反转前k个元素
        reverse(nums, 0, k - 1);
        // 最后反转剩余元素
        reverse(nums, k, len - 1);
    }
    // 反转数组
    // 时间复杂度：O(n)，空间复杂度：O(1)
       public void reverse(int[]nums, int start, int end){
        // 双指针交换数组元素，直到l和r相遇
        int l = start;
        int r = end;
        while(l < r){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            r--;
            l++;
        }
    }
}
