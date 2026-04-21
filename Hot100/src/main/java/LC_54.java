import java.util.ArrayList;
import java.util.List;

/**
 * 题目：螺旋矩阵
 * 思路：模拟螺旋遍历，用四个变量记录边界。
 * 按顺时针方向循环：左→右（收缩上边界）、上→下（收缩右边界）、右→左（收缩下边界）、下→上（收缩左边界）。
 * 每遍历完一条边后收缩对应边界，最后当边界相遇时停止。
 * 注意：当只剩一行或一列时，需额外判断避免重复遍历。
 * 时间复杂度：O(mn)，空间复杂度：O(1)
 */
public class LC_54 {
    public List<Integer> spiralOrder(int[][] matrix){
        // 用四个变量记录当前遍历上、下、左、右边界
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        List<Integer> ans = new ArrayList<>();
        // 遍历矩阵，收缩边界直到边界相遇
        while(left <= right && top <= bottom){
            // 从左到右遍历当前行，上边界收缩
            for(int i = left; i <= right; i++){
                ans.add(matrix[top][i]);
            }
            top++;
            // 从上到下遍历当前列，右边界收缩
            for(int i = top; i <= bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;
            // 从右到左遍历当前行，下边界收缩
            // 因为上面收缩了上，判断是否还有下边界，避免重复遍历
            if(top <= bottom){
               for(int i = right; i >= left; i--){
                ans.add(matrix[bottom][i]);
                }
               bottom--;
            }
            // 从下到上遍历当前列，左边界收缩
            // 因为上面收缩了右，判断是否还有左边界，避免重复遍历
            if(left <= right){
               for(int i = bottom; i >= top; i--){
                ans.add(matrix[i][left]);
                }
                left++;
            }

        }
        return ans;
    }
}
