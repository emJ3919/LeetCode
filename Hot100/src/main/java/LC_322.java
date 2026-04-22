/**
 * 题目：零钱兑换
 * 思路：动态规划。
 * dp[i]表示金额i需要的最少硬币数，初始化dp[0]=0，其余为-1（无方案）。
 * 从小到大遍历amount计算每个amount的dp[i]。
 * 遍历每个金额，对于每种硬币，若金额大于等于硬币面值且子金额有方案，则更新dp[i]。
 * 若dp[i]无方案则直接赋值，否则取较小值。
 * 返回dp[amount]。
 * 时间复杂度：O(amount * n)，空间复杂度：O(amount)。
 */
public class LC_322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // dp[i]表示金额i需要的最少币数
        // 初始化dp[i]=-1（默认没方案）
        for (int i = 0; i <= amount; i++){
            dp[i] = -1;
        }
        // 初始化dp[0]为后续推导做准备，0元需要0个币
        dp[0] = 0;
        for (int i = 0; i <= amount; i++){
            for (int coin: coins){
                // 判断能拿的条件：当前要的金额比coin大并且可以选择拿
                if (i >= coin && dp[i - coin] != -1){
                    // 还没方案，选择当前硬币作为方案
                    if (dp[i] == -1){
                        dp[i] = dp[i - coin] + 1;
                    }
                    // 已经有方案，选择数量少的
                    else {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
        }
        return dp[amount];
    }
}
