public class LC_200 {
    public int numIslands(char[][] grid){
        int island = 0;
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
