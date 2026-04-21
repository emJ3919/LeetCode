import java.util.*;

/**
 * 题目：两数之和
 * 思路：用HashMap记录已遍历的数字。
 * 遍历时，对于当前数nums[i]，检查map中是否存在 target - nums[i]。
 * 存在则返回两个下标，不存在则把当前数存入map。
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class LC_1 {
    public int[] twoSum(int[] nums, int target) {
        // map存数字 下标
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                // 判断map里是否存在与当前数和为target的
                return new int[]{map.get(target - nums[i]), i};
            }
            // 当前数加入map
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
