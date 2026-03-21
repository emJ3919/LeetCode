public class LC_79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (backTracing(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTracing(char[][] board, String word, int row, int col, int cur){
        // 如果当前位置和要比较的不等，直接返回false
        if (board[row][col] != word.charAt(cur)) return false;
        // 如果当前已经是最后一个待比较，且相等 就返回true;
        if (cur == word.length() - 1 && board[row][col] == word.charAt(cur)) return true;
        // 当前位置比较通过，设置为‘#’ 标记为已经比较，并向四个方向进入下次递归
        // 备份当前位置，用于回溯
        char tmp = board[row][col];
        // 标记当前位置已经使用，防止重复找
        board[row][col] = '#';
        boolean found = false;
        // 只要有一条路能找到，就记为true
        // 上
        if (row - 1 >=0){
            if(backTracing(board, word, row - 1, col, cur + 1)) found = true;
        }
        // 左
        if (col - 1 >=0){
            if(backTracing(board, word, row, col - 1, cur + 1)) found = true;
        }
        // 下
        if (row + 1 < board.length){
            if(backTracing(board, word, row + 1, col, cur + 1)) found = true;
        }
        // 右
        if (col + 1 < board[0].length){
            if(backTracing(board, word, row, col + 1, cur + 1)) found = true;
        }
        // 找到了
        if (found) return found;
        // 没找到，回溯
        board[row][col] = tmp;
        return false;
    }
}
