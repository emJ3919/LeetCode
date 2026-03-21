public class LC_416 {
    public boolean canPartition(int[] nums){
        int sum = 0;
        int max = nums[0];
        //问题转化
        for(int num: nums){
            sum += num;
            max = Math.max(max, num);
        }
        if(sum % 2 == 1 || max > sum / 2){
            return false;
        }
        //用 0 1 背包问题解决：数组中的数能不能装满容量为target的背包。
        int target = sum / 2;
        //dp[i]含义：容量为i的背包所装物品的最大价值。
        int[] dp = new int[target + 1];
        //遍历物品（num）
        for (int num : nums){
            //遍历背包（容量为target），一维dp必须倒序遍历才能保证每个物品（num）只取一次。
            for (int i = target; i >= num; i--){
                //dp[i]：不选择当前物品（数字）加入背包。
                //dp[i - num] + num：选择当前物品加入背包，就要先腾出num的空间，再加上num的价值。
                //这道题num的空间和价值是相同的。
                dp[i] = Math.max(dp[i], dp[i - num] + num);
            }
        }
        if (dp[target] == target){
            return true;
        }else {
            return false;
        }
    }
}
