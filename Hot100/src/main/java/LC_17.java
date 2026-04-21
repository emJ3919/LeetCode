import java.util.*;

/**
 * 题目：电话号码的字母组合
 * 思路：回溯。
 * 建立数字与字母的映射关系。
 * 遍历每个数字，对应的每个字母都有选择和不选择的情况。
 * 从第一个数字开始，遍历其对应的字母，选择后递归处理下一个数字。
 * 递归完成后撤销选择，直到处理完所有数字，将当前结果加入答案列表。
 * 时间复杂度：O(4^n)，空间复杂度：O(n)。
 */
public class LC_17 {
    public List<String> letterCombinations(String digits) {
        // 初始化哈希表，建立数字与字符的关系
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> ans = new ArrayList<>();
        backTracing(ans, new StringBuffer(), digits, map, 0);
        return ans;
    }

    private void backTracing(List<String> ans, StringBuffer oneAns,
        String digits, Map<Character, String> map, int cur){
        // 结果数组大小达到输入长度，记录结果
        if (cur == digits.length()){
            ans.add(oneAns.toString());
            return;
        }
        // 获取数字对应的字符串
        String str = map.get(digits.charAt(cur));
        for (int j = 0; j < str.length(); j++){
            // 选择第j位
            oneAns.append(str.charAt(j));
            // 递归选择下一位输入数字的对应
            backTracing(ans, oneAns, digits, map, cur + 1);
            // 撤销选择
            oneAns.deleteCharAt(cur);
        }
    }
}
