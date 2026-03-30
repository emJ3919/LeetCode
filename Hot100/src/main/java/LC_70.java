public class LC_70 {
    public int climbStairs1(int n) {
        if (n == 1) return 1;
        // dp[i]：到楼梯i有dp[i]种方法
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
    }

    // 优化，压缩
    public int climbStairs(int n) {
        if (n == 1) return 1;
        // 只记录前两个位置的方法数即可
        int pre2 = 1;
        int pre1 = 2;
        for (int i = 3; i <= n; i++){
            // 暂存当前的一步，接下来会变成前两步
            int tmp = pre1;
            // 下次的前一步等于当前的方法，就是前两步的方法和
            pre1 = pre1 + pre2;
            // 下次的前两步就是这次的前一步
            pre2 = tmp;
        }
        return pre1;
    }
}
