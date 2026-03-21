import sun.jvm.hotspot.gc.z.ZGranuleMapForForwarding;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC_994 {
    public int orangesRotting(int[][] grid) {
        // 记录总橘子数和腐烂的橘子数
        int totalOrange = 0;
        int rottedOrange = 0;
        // 初始化队列
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
        // 记录遍历层数，也就是腐烂时间
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
        if (rottedOrange == totalOrange){
            // 最后一次遍历弹出所有腐烂橘子，不算在总时长里面
            return Math.max(0,deep - 1);
        }else {
            return -1;
        }
    }
}
