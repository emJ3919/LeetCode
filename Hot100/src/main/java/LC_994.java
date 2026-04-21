import java.util.*;

/**
 * 题目：腐烂的橘子
 * 思路：广度优先搜索。
 * 先遍历一遍统计橘子数量和所有腐烂橘子的坐标，加入队列。
 * 进行层次遍历，每遍历完一层说明过了一分钟，该层腐烂橘子将周围新鲜橘子腐烂并入队。
 * 用变量记录腐烂的橘子数量，最后判断是否所有橘子都腐烂了。
 * 若全部腐烂返回层数减一（最后一层只是弹出不腐烂），否则返回-1。
 * 时间复杂度：O(mn)，空间复杂度：O(mn)。
 */
public class LC_994 {
    public int orangesRotting(int[][] grid) {
        // 记录总橘子数和腐烂的橘子数
        int totalOrange = 0;
        int rottedOrange = 0;
        // 初始化队列，记录腐烂橘子的坐标
        Deque<int[]> dq = new LinkedList<>();
        // 遍历一遍加入所有腐烂橘子和计数
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                // 腐烂橘子入队，计数
                if (grid[i][j] == 2){
                    totalOrange++;
                    int[] tmp = {i, j};
                    dq.offer(tmp);
                }else if (grid[i][j] == 1){
                    totalOrange++;
                }
            }
        }
        // 层次遍历，记录遍历层数，也就是腐烂时间
        int deep = 0;
        while (!dq.isEmpty()){
            int len = dq.size();
            deep++;
            // 遍历当前层数橘子出队
            for (int i = 0; i<len; i++){
                int[] tmp = dq.poll();
                rottedOrange++;
                int row = tmp[0];
                int col = tmp[1];
                // 上
                if (row - 1 >= 0 && grid[row - 1][col] == 1){
                    // 上方橘子入队
                    dq.offer(new int[] {row - 1, col});
                    // 加入队列的橘子状态设置为已经腐烂
                    grid[row - 1][col] = 2;
                }
                // 下
                if (row + 1 < grid.length && grid[row + 1][col] == 1){
                    dq.offer(new int[] {row + 1, col});
                    grid[row + 1][col] = 2;
                }
                // 左
                if (col - 1 >= 0 && grid[row][col - 1] == 1){
                    dq.offer(new int[] {row, col - 1});
                    grid[row][col - 1] = 2;
                }
                // 右
                if (col + 1 < grid[0].length && grid[row][col + 1] == 1){
                    dq.offer(new int[] {row, col  + 1});
                    grid[row][col + 1] = 2;
                }
            }
        }
        // 如果所有橘子都腐烂了，返回腐烂时间
        if (rottedOrange == totalOrange){
            // 最后一次遍历弹出所有腐烂橘子，不算在总时长里面
            return Math.max(0,deep - 1);
        }else {
            return -1;
        }
    }
}
