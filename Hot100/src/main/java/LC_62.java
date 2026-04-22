/**
 * 题目：不同路径
 * 思路：动态规划。
 * 机器人只能向下或向右移动，所以每个位置的路径数等于上面和左面的路径数之和。
 * 第一行和第一列只有一种走法（一直向下或一直向右）。
 * 遍历填表，dp[i][j] = dp[i-1][j] + dp[i][j-1]。
 * 返回右下角的值。
 * 时间复杂度：O(mn)，空间复杂度：O(mn)。
 */
public class LC_62 {
    public int uniquePaths(int m, int n) {
        // dp[i][j]：i，j位置的路径数
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0){// 第一行和第一列只有一条路径
                    dp[i][j] = 1;
                }else {// 可以从左边和上边过来
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
