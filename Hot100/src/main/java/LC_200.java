/**
 * 题目：岛屿数量
 * 思路：深度优先搜索。
 * 遍历网格，遇到陆地'1'则岛屿数加一，然后进行深度优先搜索将整座岛屿淹没（变为'0'）。
 * 递归向上下左右四个方向扩散，将所有相连的'1'都变为'0'。
 * 时间复杂度：O(mn)，空间复杂度：O(mn)，递归栈深度。
 */
public class LC_200 {
    public int numIslands(char[][] grid){
        // 记录岛屿数量
        int island = 0;
        // 遍历网格，遇到1则为岛屿，进行深度优先遍历，淹没整座岛
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == '1'){
                    island++;
                    dfs(grid, i, j);
                }
            }
        }
        return island;
    }
    // 深度优先遍历，淹没整座岛
    private void dfs(char[][] grid, int r, int c){
        // 访问过的位置设为0，避免重复访问
        grid[r][c] = '0';
        // 上
        if (r - 1 >=0 && grid[r - 1][c] == '1') dfs(grid, r - 1, c);
        // 下
        if (r + 1 < grid.length && grid[r + 1][c] == '1') dfs(grid, r + 1, c);
        // 左
        if (c - 1 >= 0 && grid[r][c - 1] == '1') dfs(grid, r, c - 1);
        // 右
        if (c + 1 < grid[0].length && grid[r][c + 1] == '1') dfs(grid, r, c + 1);
    }
}
