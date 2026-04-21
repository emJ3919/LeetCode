/**
 * 题目：矩阵置零
 * 思路：两遍扫描。
 * 第一遍遍历矩阵，用两个数组记录需要置零的行索引和列索引。
 * 第二、三遍按记录的索引分别置零对应行和列。
 * 时间复杂度：O(mn)，空间复杂度：O(m+n)
 */
public class LC_73 {
    public void setZeroes(int[][] matrix){
        int row_len = matrix.length;
        int col_len = matrix[0].length;
        // 记录应该置0的行和列的索引，用1表示
        int[] row = new int[row_len];
        int[] col = new int[col_len];
        for (int i = 0; i < row_len; i++){
            for(int j = 0; j < col_len; j++){
                // 如果当前元素为0，记录当前行和列的索引
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        // 遍历记录的行索引，置0
        for (int i = 0; i < row_len; i++){
            if(row[i] == 1){
                for (int j = 0; j < col_len; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        // 遍历记录的列索引，置0
        for (int i = 0; i < col_len; i++){
            if(col[i] == 1){
                for (int j = 0; j < row_len; j++){
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
