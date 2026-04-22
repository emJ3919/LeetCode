import java.util.Arrays;

/**
 * 题目：最长递增子序列
 * 思路：动态规划。
 * dp[i]表示以第i个元素结尾的最长递增子序列长度。
 * 初始化dp[i]=1（每个元素自己就是一个长度为1的子序列）。
 * 遍历i之前的每个元素j，若当前位置的元素比j大，就可以接在以nums[j]结尾的子序列后面。
 * dp[i] = max(dp[i], dp[j] + 1)。
 * 用变量记录遍历过程中的最大长度，最后返回。
 * 时间复杂度：O(n²)，空间复杂度：O(n)。
 */
public class LC_300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        // dp[i]：选择i位置结尾的最长递增子序列长度
        int[] dp = new int[len];
        // 初始化为1
        Arrays.fill(dp, 1);
        // 要记录最大长度，因为dp[i]不一定是结果
        int max = 1;
        for (int i = 1; i < nums.length; i++){
            // 选择i的前部分，计算最大的
            for (int j = 0; j < i; j++){
                // 当前比选择的前面大才能加入后面
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
