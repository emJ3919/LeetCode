import java.util.List;

public class LC_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // 长度为i的字符串能不能组合成功
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++){
            for (String word: wordDict){
                if (i >= word.length()){
                    // 是否由word结尾
                    dp[i] = dp[i - word.length()] && s.startsWith(word, i - word.length());
                    // 已经能组合成功就不用找了，防止干扰
                    if (dp[i]) break;
                }
            }
        }
        return dp[len];
    }
}
