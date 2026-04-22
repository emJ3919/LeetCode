/**
 * 题目：最小路径和
 * 思路：动态规划。
 * 机器人只能向下或向右移动，所以每个位置的最小路径和等于上面和左面的最小值加上当前值。
 * 第一行只能从左边过来，第一列只能从上边过来。
 * 遍历填表，dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]。
 * 返回右下角的值。
 * 时间复杂度：O(mn)，空间复杂度：O(mn)。
 */
public class LC_64 {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        // 代表当前位置的最小路径和
        int[][] dp = new int[r][c];
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (i == 0 && j == 0){// 第一个元素
                  dp[i][j] = grid[0][0];
                } else if (i == 0 && j != 0){// 第一行
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0 && i != 0){// 第一列
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else{ // 其它情况 计算最小，从左或者上过来
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[r - 1][c - 1];
    }
}
