/**
 * 题目：搜索二维矩阵 II
 * 思路：利用矩阵特性，从右上角搜索（或者左下）
 * 右上角 matrix[0][n-1] 是该行最大值、该列最小值，大了可以向左移动，小了可以向下移动。
 * 最多走 m+n 步，时间复杂度 O(m+n)。
 * 方法1：暴力遍历 O(mn)，方法2：每行二分 O(m log n)。
 * 时间复杂度：O(m+n)，空间复杂度：O(1)
 */
public class LC_240 {

    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        // 选择右上角作为搜索起点（左下角也可以），可以确定向左或向下移动
        int col = n - 1;
        int row = 0;
        // 从右上角开始搜索
        while(col >= 0 && row < m){
            if(matrix[row][col] == target){
                return true;
            }
            // 当前元素小于目标值，说明目标值在当前行的下方
            else if(matrix[row][col] < target){
                row++;
            }
            // 当前元素大于目标值，说明目标值在当前列的左侧方
            else{
                col--;
            }
        }
        return false;
    }

    
    public boolean solution1(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean solution2(int[][] matrix, int target){
        int n = matrix[0].length;
        for(int[] nums: matrix){
            int l = 0;
            int r = n - 1;
            int mid;
            while (l <= r){
                mid = (l + r) / 2;
                if(nums[mid] == target){
                    return true;
                }else if (nums[mid] <= target){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
