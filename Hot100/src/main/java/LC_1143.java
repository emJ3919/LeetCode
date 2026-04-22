/**
 * 题目：最长公共子序列
 * 思路：动态规划。
 * dp[i][j]表示text1前i个字符和text2前j个字符的最长公共子序列长度。
 * 初始化第一行和第一列为0（空字符串与任意字符串的公共子序列长度为0）。
 * 遍历两个字符串，如果最后一个字符相等，说明当前字符在公共子序列中，长度加一。
 * 否则取上一个状态（text1减少一个或者text2减少一个）的较大值。
 * 遍历填表，返回dp[m][n]。
 * 时间复杂度：O(mn)，空间复杂度：O(mn)。
 */
public class LC_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // dp[i][j]:text1的前i个和text2的前j个的最长公共子序列，第一行和第一列为0，因为表示一个字符串长度为0
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                // 当前最后一个位置相等，说明公共子序列长度+1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    // 上一个状态取大的
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
