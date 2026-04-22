/**
 * 题目：编辑距离
 * 思路：动态规划。
 * dp[i][j]表示word1前i个字符变为word2前j个字符所需的最少操作次数。
 * 初始化边界：word1为空需要j次插入，word2为空需要i次删除。
 * 遍历word1和word2，根据当前字符是否相等，更新dp[i][j]。
 * 若当前字符相等则不需要操作，dp[i][j] = dp[i-1][j-1]。
 * 否则需要三种操作之一：插入（dp[i][j-1] + 1）、删除（dp[i-1][j] + 1）、替换（dp[i-1][j-1] + 1），取最小值。
 * 遍历填表，返回dp[m][n]。
 * 时间复杂度：O(mn)，空间复杂度：O(mn)。
 */
public class LC_72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp[i][j]：word1的前i个字符变为word2的前j个字符要用的最少操作次数
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= n; j++){
                // word1为空，word2的前j个字符变为word1的前i个字符要用的最少操作次数为j个
                if (i == 0) dp[i][j] = j;
                // word2为空，word1的前i个字符变为word2的前j个字符要用的最少操作次数为i个
                else if (j == 0) dp[i][j] = i;
                // 当前两个位置相等，说明不需要操作
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
