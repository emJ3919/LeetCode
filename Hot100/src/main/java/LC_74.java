/**
 * 题目：搜索二维矩阵
 * 思路：两次二分。
 * 矩阵特性：每行从左到右递增，每列从上到下递增，且第一列也是递增的。
 * 先二分查找行，根据每行第一个元素确定目标可能在哪一行。
 * 确定行后在该行二分查找列。
 * 若两处都未找到目标则返回false。
 * 时间复杂度：O(log m + log n)，空间复杂度：O(1)。
 */
public class LC_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowL = 0;
        int rowR = matrix.length - 1;
        // 二分查找行
        while (rowL <= rowR){
            int mid = rowL + (rowR - rowL)/2;
            if (matrix[mid][0] == target) return true;
            if (matrix[mid][0] < target){
                rowL = mid + 1;
            }else {
                rowR = mid - 1;
            }
        }
        // 确定行，因为rowL一定停在>target的位置
        if (rowL == 0){
            return false;
        }
        rowL--;
        // 二分查找列
        int colL = 0;
        int colR = matrix[0].length - 1;
        while (colL <= colR){
            int mid = colL + (colR - colL)/2;
            if (matrix[rowL][mid] == target) return true;
            if (matrix[rowL][mid] < target){
                colL = mid + 1;
            }else {
                colR = mid - 1;
            }
        }
        // 前面都没找到，返回false
        return false;
    }
}
