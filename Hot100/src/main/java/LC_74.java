public class LC_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowL = 0;
        int rowR = matrix.length - 1;
        while (rowL <= rowR){
            int mid = rowL + (rowR - rowL)/2;
            if (matrix[mid][0] == target) return true;
            if (matrix[mid][0] < target){
                rowL = mid + 1;
            }else {
                rowR = mid - 1;
            }
        }
        // 确定行，因为rowL一定停在>=target的位置
        if (rowL == 0){
            return false;
        }
        rowL--;
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
        return false;
    }
}
