import java.util.List;

/**
 * 题目：单词拆分
 * 思路：动态规划。
 * dp[i]表示长度为i的字符串能否组合成功，dp[0]=true作为初始条件。
 * 遍历字符串的每个位置，对于每个位置遍历字典中的单词。
 * 若当前位置大于等于单词长度，且前面的部分能组合成功，且当前字符串以该单词结尾，则dp[i]=true。
 * 若已找到成功方案则跳出循环。
 * 返回dp[len]。
 * 时间复杂度：O(n * m * k)，空间复杂度：O(n)。
 */
public class LC_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // 长度为i的字符串能不能组合成功
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++){
            for (String word: wordDict){
                // 长度大于等于word的长度才能选word结尾
                if (i >= word.length()){
                    // 是否由word结尾
                    dp[i] = dp[i - word.length()] && s.startsWith(word, i - word.length());
                    // 已经能组合成功就不用找了
                    if (dp[i]) break;
                }
            }
        }
        return dp[len];
    }
}
