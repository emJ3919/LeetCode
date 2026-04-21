import java.util.ArrayList;
import java.util.List;

/**
 * 题目：括号生成
 * 思路：回溯。
 * 左括号可以随时添加，只要不超过n个。
 * 右括号必须在左括号之后添加，数量不能超过左括号数量。
 * 当左右括号都达到n个时，将当前括号组合加入答案列表。
 * 递归过程中撤销选择，尝试另一种括号。
 * 时间复杂度：O(4^n / sqrt(n))，空间复杂度：O(n)。
 */
public class LC_22 {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        // left 左括号数量，right 右括号数量
        backTracing(new StringBuffer(), n, 0, 0);
        return ans;
    }
    
    private void backTracing(StringBuffer oneAns, int n , int left, int right){
        if (left == n && right == n){
            ans.add(oneAns.toString());
            return;
        }
        // 加入左括号
        if (left < n){
            oneAns.append('(');
            backTracing(oneAns, n, left + 1, right);
            // 回溯，删除刚刚加的左括号
            oneAns.deleteCharAt(oneAns.length() - 1);
        }
        // 加入右括号，右括号数量不能超过左括号数量
        if (right < left){
            oneAns.append(')');
            backTracing(oneAns, n, left, right + 1);
            // 回溯，删除刚刚加的右括号
            oneAns.deleteCharAt(oneAns.length() - 1);
        }
    }
}
