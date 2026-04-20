public class LC_72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp[i][j]：word1的前i个字符变为word2的前j个字符要用的最少操作次数
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= n; j++){
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                // 当前两个位置相等
                else if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else { // 这个位置不相等
                    // 插入，i在前一位的状态再进行一次操作,dp[i][j] = dp[i][j - 1] + 1;
                    // 删除，j在前一位的状态再进行一次操作,dp[i][j] = dp[i - 1][j] + 1;
                    // 替换，i,j都在前一位的状态再进行一次操作,dp[i][j] = dp[i - 1][j - 1] + 1;
                    // 取三者最小
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                }
            }
        }
        return dp[m][n];
    }
}
