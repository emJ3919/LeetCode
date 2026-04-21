/**
 * 题目：最大子数组和
 * 思路：贪心。
 * 维护当前子数组的前缀和pre_sum，若前缀和小于0则重置为0（丢弃）。
 * 每一步用max记录pre_sum和历史最大值的较大值。
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class LC_53 {
    public int maxSubArray(int[] nums){
        // 记录当前子数组的最大和
        int max = nums[0];
        // 记录当前前缀和
        int pre_sum = 0;
        for (int num: nums){
            max = Math.max(max, pre_sum + num);
            // 更新当前前缀和,如果当前前缀和小于0,则重置为0(不要前面的了)
            pre_sum += num;
            if(pre_sum < 0){
                pre_sum = 0;
            }
        }
        return max;
    }
}
