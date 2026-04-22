/**
 * 题目：最长回文子串
 * 思路：
 * 方法1（推荐)：中心扩散。回文串一定存在中心，枚举每个字符作为中心，向两边扩散判断是否回文。
 * 分两种情况：单点扩散（aba，中心是一个字符）和双点扩散（abba，中心是两个字符）。
 * 遍历每个位置，先尝试单点扩散找回文，再尝试双点扩散找回文，比较取较长的。
 * 方法2：动态规划。dp[i][j]表示s[i:j]是否为回文串，dp[i][j] = dp[i+1][j-1] && s[i]==s[j]。
 * 从下向上、从左向右遍历填表，记录最长回文起点和长度。
 * 方法3：暴力枚举。枚举所有子串，判断是否为回文并记录最长的。
 * 时间复杂度：中心扩散O(n²)，动态规划O(n²)，暴力O(n³)。空间复杂度：中心扩散O(1)，动态规划O(n²)，暴力O(1)。
 */
public class LC_5 {
    // 中心扩散法
    public String longestPalindrome_expand(String s) {
        int len = s.length();
        if (len == 1) return s;
        // 记录最长回文长度和起点终点
        int[] ans = {1,0,0};
        for (int i = 0; i < len; i++){
            // 单点扩散：找 aba 这种类型的回文
            int[] one = expand(s,i,i);
            // 双点扩散：找 abba 这种类型的回文
            if (i - 1 >=0 && s.charAt(i-1) == s.charAt(i)){
                int[] two = expand(s,i-1,i);
                // 更新为更长的
                if (two[0] > one[0]) one = two;
            }
            // 更新答案为更长的
            if (one[0] > ans[0]) ans = one;
        }
        return s.substring(ans[1], ans[2] + 1);
    }
    private int[] expand(String s, int l, int r){
        // 没到边界且还是回文就继续扩
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        // 长 起点 终点，注意最后l和r都多走了一步
        return new int[]{r - l - 1, l + 1, r - 1};
    }

    // 动态规划
    public String longestPalindrome_dp(String s) {
        int len = s.length();
        // dp[i][j]: s[i:j]是否为回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化对角线为true，因为一个字符一定是回文
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                if (i == j) dp[i][j] = true;
            }
        }
        // 记录长度和起点
        int maxLen = 1;
        int start = 0;
        // 状态方程：dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j] 
        // 只适用长度大于二的情况，不然会越界
        // 所以从下向上遍历i，从左向右遍历j
        for (int i = len - 1; i >= 0; i--){
            // 只需要从i + 1开始，因为右边索引肯定要大于左边
            for (int j = i + 1; j < len; j++){
                // 长度为二，只要两头相等就可以
                dp[i][j] = (j - i == 1 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j); 
                // 是回文，比较记录
                if (dp[i][j] && j - i + 1 > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    // 暴力解法
    public String longestPalindrome_baoli(String s) {
        int len = s.length();
        // 0:记录最长回文长度 1：回文起点 2：回文终点
        int[] tmp = new int[3];
        for (int i = 0; i < len; i++){
            for (int j = 0; j <= i; j++){
                // 判断s[j:i]是不是回文
                if (verify(s, j, i)){
                    // 当前长度比之前记录的长度长，更新记录
                    if (i - j + 1 > tmp[0]){
                        tmp[0] = i - j + 1;
                        tmp[1] = j;
                        tmp[2] = i;
                    }
                }
            }
        }
        return s.substring(tmp[1], tmp[2] + 1);
    }

    private boolean verify(String s, int l , int r){
        while (l < r){
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
