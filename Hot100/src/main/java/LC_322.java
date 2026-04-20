public class LC_322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 初始化为默认没方案
        for (int i = 0; i <= amount; i++){
            dp[i] = -1;
        }
        // 初始化dp[0]为后续推导做准备
        dp[0] = 0;
        for (int i = 0; i <= amount; i++){
            for (int coin: coins){
                // 判断能拿的条件：当前要的金额比coin大并且可以选择拿
                if (i >= coin && dp[i - coin] != -1){
                    // 还没方案
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
