public class LC_279 {
    public int numSquares(int n) {
        // dp[i]：数字i最少需要dp[i]个完全平方数组成
        int[] dp = new int[n + 1];
        // 初始化为最差情况，全由1组成
        for (int i = 0; i <= n; i++){
            dp[i] = i;
        }
        // 更新dp
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
