/**
 * 题目：旋转图像
 * 思路：原地旋转，按层从外向内处理。
 * 用left和right记录当前层的边界。因为行和列相等，所以用left和right记录当前层的边界即可
 * 对每一层，用临时变量保存一个元素，将四边的元素按顺时针方向依次交换。
 * 时间复杂度：O(n²)，空间复杂度：O(1)
 */
public class LC_48 {
    public void rotate(int[][] matrix){
        // 记录当前旋转的层，从外向内旋转
        // 因为行和列相等，所以用left和right记录当前层的边界即可
        int left = 0;
        int right = matrix.length - 1;
        // 当层旋转完成后，内层继续旋转，最里面只有一个元素，不用旋转
        while(left < right){
            // 循环旋转这一层的所有元素
            for (int i = 0; i < right - left; i++){
                // 记录当前待替换的元素，上边第i个元素
                int tmp = matrix[left][left + i];
                // 左边从下往上第i个元素，替换上边第i个元素
                matrix[left][left + i] = matrix[right - i][left];
                // 下边从右往左第i个元素，替换左边从下往上第i个元素
                matrix[right - i][left] = matrix[right][right - i];
                // 右边从上往下第i个元素，替换下边从右往左第i个元素
                matrix[right][right - i] = matrix[left + i][right];
                // 最后上边第i个元素，补上右边从上往下第i个元素
                matrix[left + i][right] = tmp;
            }
            // 收缩层
            left++;
            right--;
        }
    }
}
