import java.util.HashSet;
import java.util.Set;



/**
 * 题目：无重复字符的最长子串
 * 思路：用HashSet记录窗口内的字符，使用滑动窗口。
 * 遍历字符串，左边界i固定，右边界window向右扩展。
 * 遇到重复字符时，左边界右移并移除对应字符，直到窗口内无重复。
 * 记录窗口最大长度。
 * 时间复杂度：O(n)，空间复杂度：O(min(m,n))，m为字符集大小
 */
public class LC_3 {
    public int lengthOfLongestSubstring(String s){
        // 哈希表记录窗口内的字符是否重复
        Set<Character> set = new HashSet<>();
        // 窗口右边界
        int window = -1;
        int len = s.length();
        // 最大长度
        int max_len = 0;
        for (int i = 0; i < len; i++){
            // 窗口左边界移动，set中删除对应的字符
            if (i !=0 ){
                set.remove(s.charAt(i - 1));
            }
            // 窗口右边界移动，set中添加对应的字符
            while (window + 1 < len && !set.contains(s.charAt(window + 1))){
                window++;
                set.add(s.charAt(window));
                // 更新最大长度
                max_len = Math.max(max_len, window - i + 1);
            }
        }
        return max_len;
    }

}
