/**
 * 题目：分割等和子集
 * 思路：动态规划（0-1背包）。
 * 问题转化为：数组能否分成和相等的两部分，即数组中是否存在子集和为sum/2。
 * 快速判断：若和为奇数或最大数大于和的一半，则不能分割。
 * 将其转化为0-1背包问题：数组中的数能否装满容量为target的背包。
 * dp[i]表示容量为i的背包能装的最大和。
 * 遍历每个数，倒序遍历背包容量，更新dp[i]。
 * 最后若dp[target]==target说明可以装满。
 * 时间复杂度：O(n * target)，空间复杂度：O(target)。
 */
public class LC_416 {
    public boolean canPartition(int[] nums){
        int sum = 0;
        // 用于快速判断能不能分成相等的两部分
        int max = nums[0];
        //问题转化，求和的一半能不能被数组中的数组成
        for(int num: nums){
            sum += num;
            max = Math.max(max, num);
        }
        // 如果和为奇数，或者最大数大于和的一半，说明不能分成相等的两部分
        if(sum % 2 == 1 || max > sum / 2){
            return false;
        }
        //用 0 1 背包问题解决：数组中的数能不能装满容量为target的背包。
        int target = sum / 2;
        //dp[i]含义：target为i的背包，从数组中选择数，能组成的最大和为dp[i]。
        int[] dp = new int[target + 1];
        //遍历物品（num）
        for (int num : nums){
            //遍历背包（容量为target），一维dp必须倒序遍历才能保证每个物品（num）只取一次。
            // 因为dp[i - num]还没选这个num，所以可以安全地使用。
            for (int i = target; i >= num; i--){
                //dp[i]：不选择当前数字
                //dp[i - num] + num：选择当前数，就要先找出i - num的价值，再加上num的价值。
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
