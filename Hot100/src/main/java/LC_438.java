import java.util.*;

/**
 * 题目：找到字符串中所有字母异位词
 * 思路：使用滑动窗口 + 频次数组。
 * 用两个数组分别记录窗口内和p的字符频次，窗口大小为pLen。
 * 初始化时统计p和s前pLen个字符的频次并比较。
 * 窗口右移时，移除左边字符、加入右边字符，比较两数组是否相等。
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class LC_438 {
        public List<Integer> findAnagrams(String s, String p) {
            // 记录s，p中每个字符出现的次数
            int[] sCount = new int[26];
            int[] pCount = new int[26];
            int sLen = s.length();
            int pLen = p.length();
            List<Integer> ans = new ArrayList<>();
            // 如果s长度小于p长度，直接返回空列表
            if (sLen < pLen){
                return ans;
            }
            //初始化窗口频次，窗口大小就是pLen
            for (int i = 0; i < pLen; i++){
                sCount[s.charAt(i) - 'a']++;
                pCount[p.charAt(i) - 'a']++;
            }
            //这里先比较窗口在初始位置的情况，因为后面要先移除i=0的位置
            if (Arrays.equals(sCount, pCount)){
                ans.add(0);
            }
            for (int i = 0; i < sLen - pLen; i++){
                //计算右移窗口后的频次
                sCount[s.charAt(i) - 'a']--;
                sCount[s.charAt(i + pLen) - 'a']++;
                // 比较窗口内字符出现次数是否相等
                if (Arrays.equals(sCount, pCount)){
                    ans.add(i + 1);
                }
            }
            return ans;
    }
}
