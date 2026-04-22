/**
 * 题目：乘积最大子数组
 * 思路：动态规划。
 * 由于存在负数，最大乘积可能由最小乘积乘负数得到。
 * dpMax[i]和dpMin[i]分别表示以第i个元素结尾的最大和最小乘积。
 * 若当前数为正数，则最大乘积由之前的最大乘积乘当前数得到。
 * 若当前数为负数，则最大乘积由之前的最小乘积乘当前数得到。
 * 初始化dpMax[0]和dpMin[0]为第一个数，遍历更新并记录最大乘积。
 * 时间复杂度：O(n)，空间复杂度：O(n)。
 */
public class LC_152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        // 当前位置结尾的最大和最小乘积
        // 因为有负数，所以需要记录最小值
        int[] dpMax = new int[len];
        int[] dpMin = new int[len];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        // 记录最大值
        int max = nums[0];
        for (int i = 1; i < len; i++){
            // 计算最大值大于0乘大的，小于0乘小的
            if (nums[i] > 0){
                // 可以选择拼前面的或者就以当前为子数组起点
                dpMax[i] = Math.max(nums[i] * dpMax[i - 1], nums[i]);
                dpMin[i] = Math.min(nums[i] * dpMin[i - 1], nums[i]);
            }else {
                dpMin[i] = Math.min(nums[i] * dpMax[i - 1], nums[i]);
                dpMax[i] = Math.max(nums[i] * dpMin[i - 1], nums[i]);
            }
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }
}
