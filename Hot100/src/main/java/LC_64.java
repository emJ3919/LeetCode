public class LC_64 {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        // 代表当前位置的最小路径和
        int[][] dp = new int[r][c];
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                // 第一行
                if (i == 0 && j == 0){
                  dp[i][j] = grid[0][0];// 第一个元素
                } else if (i == 0 && j != 0){
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0 && i != 0){// 第一列
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else{ // 其它情况 计算最小
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[r - 1][c - 1];
    }
}
