import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：分割回文串
 * 思路：回溯。
 * 从起始位置开始，尝试向右扩展切分区间，判断切分的子串是否为回文。
 * 若为回文则加入结果数组，然后递归处理剩余部分。
 * 递归完成后撤销选择，尝试更长的切分区间。
 * 当切分位置到达字符串末尾时，将当前结果加入答案列表。
 * 时间复杂度：O(n * 2^n)，空间复杂度：O(n)。
 */
public class LC_131 {
    List<List<String>> ans = new ArrayList<>();
    List<String> oneAns = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTracing(s,0);
        return ans;
    }
    // 验证是否为回文，闭区间
    private boolean verify(String s, int l, int r){
        while (l < r){
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    // 递归切分：输入待切分字符串，切分起始位置
    private void backTracing(String s, int start){
        // 切分完毕，添加结果
        if (start == s.length()){
            ans.add(new ArrayList<>(oneAns));
            return;
        }
        // 遍历以start为起点的切分右边界，尝试切分
        for (int i = start + 1; i <= s.length(); i++){
            // 判断s[start,i)是否为回文，是则加入结果数组
            if (verify(s, start, i - 1)){
                // 将切分s[0,i)加入结果数组
                oneAns.add(s.substring(start,i));
                // 递归切分[i,len)部分
                backTracing(s, i);
                // 取消切分
                oneAns.remove(oneAns.size() - 1);
            }
        }
    }
}
