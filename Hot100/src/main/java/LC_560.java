import java.util.HashMap;
import java.util.Map;

/**
 * 题目：和为 K 的子数组
 * 思路：用HashMap记录前缀和出现的次数。
 * 遍历数组，维护当前前缀和pre_sum。
 * 当前前缀和减去之前的一个前缀和等于k，说明有子数组的和为k
 * 子数组个数就是前缀和为pre_sum - k的次数。
 * 每遍历一个数，更新前缀和的计数。
 * 初始化map.put(0,1)处理子数组从开头开始的情况。
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class LC_560 {
    public int subarraySum(int[] nums, int k) {
        // 记录前缀和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        //前缀和为0必须初始化，因为可能长度为1的数组就是k。
        map.put(0,1);
        int ans = 0;
        // 记录当前前缀和
        int pre_sum = 0;
        for (int num : nums) {
            pre_sum += num;
            // 当前前缀和减去之前的一个前缀和等于k，说明当前子数组的和为k
            // 所以找前缀和为pre_sum - k的次数
            if (map.containsKey(pre_sum - k)) {
                ans += map.get(pre_sum - k);
            }
            // 更新当前前缀和出现的次数
            if (map.containsKey(pre_sum)) {
                map.put(pre_sum, map.get(pre_sum) + 1);
            } else {
                map.put(pre_sum, 1);
            }
        }
        return ans;
    }
}
