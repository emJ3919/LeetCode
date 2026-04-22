/**
 * 题目：打家劫舍
 * 思路：动态规划。
 * 对于每间房子，可以选择偷或不偷。若选择偷，则不能偷前一间。
 * dp[i]表示偷到第i间房能获取的最大价值，dp[i]=max(dp[i-1], dp[i-2]+nums[i])。
 * 即当前最大价值为不偷这间房的最大价值与偷这间房加前两间最大价值中的较大值。
 * 空间优化：只保留前两个状态即可。
 * 时间复杂度：O(n)，空间复杂度：O(1)。
 */
public class LC_198 {
    public int rob(int[] nums) {
        int len = nums.length;
        // 处理小于三个房间的情况
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        // 记录偷到前两间房能获取的最大价值
        int pre2 = nums[0];
        int pre = Math.max(nums[0], nums[1]);
        // 遍历计算后面房间，这里从三号房间开始，i=2
        for (int i = 2; i < len; i++){
            // 下一轮变为pre2
            int tmp = pre;
            // 偷前一间或者当前房间+前两间房
            pre = Math.max(pre, pre2 + nums[i]);
            pre2 = tmp;
        }
        return pre;
    }
}
