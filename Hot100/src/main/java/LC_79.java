/**
 * 题目：单词搜索
 * 思路：回溯。
 * 遍历网格每个格子作为起点尝试匹配。
 * 比较当前格子字符与单词的当前字符，若匹配则标记为已访问，向四个方向递归。
 * 递归时传入下一个字符的索引，若匹配到单词末尾返回true。
 * 四个方向都没找到则回溯恢复格子状态，返回false。
 * 时间复杂度：O(mn * 4^L)，空间复杂度：O(L)，L为单词长度。
 */
public class LC_79 {
    public boolean exist(char[][] board, String word) {
        // 遍历每个位置，尝试从当前位置开始找
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
        // 标记是否找到
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
