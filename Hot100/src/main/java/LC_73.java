public class LC_73 {
    public void setZeroes(int[][] matrix){
        int row_len = matrix.length;
        int col_len = matrix[0].length;
        int[] row = new int[row_len];
        int[] col = new int[col_len];
        for (int i = 0; i < row_len; i++){
            for(int j = 0; j < col_len; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < row_len; i++){
            if(row[i] == 1){
                for (int j = 0; j < col_len; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < col_len; i++){
            if(col[i] == 1){
                for (int j = 0; j < row_len; j++){
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
