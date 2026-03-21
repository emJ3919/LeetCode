import java.util.HashMap;
import java.util.Map;

public class LC_560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //前缀和为0必须初始化，因为可能长度为1的数组就是k。
        map.put(0,1);
        int ans = 0;
        int pre_sum = 0;
        for (int num : nums) {
            pre_sum += num;
            if (map.containsKey(pre_sum - k)) {
                ans += map.get(pre_sum - k);
            }
            if (map.containsKey(pre_sum)) {
                map.put(pre_sum, map.get(pre_sum) + 1);
            } else {
                map.put(pre_sum, 1);
            }
        }
        return ans;
    }
}
