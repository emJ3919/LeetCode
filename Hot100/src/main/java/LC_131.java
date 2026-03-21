import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    // 递归切分：输入待切分字符串，切分位置，前面已切分长度，所需总长度
    private void backTracing(String s, int start){
        // 切分完毕，且切分后的是回文，添加结果
        if (start == s.length()){
            ans.add(new ArrayList<>(oneAns));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++){
            // 如果切分有效
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
