import java.util.Arrays;

public class LC_300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        // dp[i]：选择i位置结尾的最长递增子序列长度
        int[] dp = new int[len];
        // 初始化为1
        Arrays.fill(dp, 1);
        // 要记录最大长度，因为dp[i]不一定是结果
        int max = 1;
        for (int i = 1; i < nums.length; i++){
            // 选择i的前部分，计算最大的
            for (int j = 0; j < i; j++){
                // 当前比选择的前面大才能加入后面
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
