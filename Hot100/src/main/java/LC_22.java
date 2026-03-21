import java.util.ArrayList;
import java.util.List;

public class LC_22 {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
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
            // 回溯
            oneAns.deleteCharAt(oneAns.length() - 1);
        }
        // 加入右括号
        if (right < left){
            oneAns.append(')');
            backTracing(oneAns, n, left, right + 1);
            oneAns.deleteCharAt(oneAns.length() - 1);
        }
    }
}
