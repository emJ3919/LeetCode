/**
 * 题目：完全平方数
 * 思路：动态规划。
 * dp[i]表示数字i最少需要dp[i]个完全平方数组成。
 * 初始化dp[i]=i（最差情况全由1组成）。
 * 遍历每个数字，尝试递增j，用完全平方数j*j来更新dp[i]。
 * dp[i] = min(dp[i], dp[i - j*j] + 1)，即选或不选j*j的较小值。
 * 时间复杂度：O(n * sqrt(n))，空间复杂度：O(n)。
 */
public class LC_279 {
    public int numSquares(int n) {
        // dp[i]：数字i最少需要dp[i]个完全平方数组成
        int[] dp = new int[n + 1];
        // 初始化为最差情况，全由1组成
        for (int i = 0; i <= n; i++){
            dp[i] = i;
        }
        // 更新dp，1，2，3都为1，直接从4开始
        for (int i = 4; i <= n; i++){
            int j = 2;
            // 可以选择j作为组合数
            while (i - j*j >= 0){
                // 选j或者不选j
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
                // 尝试增大j
                j++;
            }
        }
        return dp[n];
    }
}
