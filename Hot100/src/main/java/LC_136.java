import java.util.HashSet;
import java.util.Set;

/**
 * 题目：只出现一次的数字
 * 思路：
 * 方法1：哈希表。遍历数组，出现两次则移除，最后剩下的就是只出现一次的数字。
 * 方法2（推荐）：异或运算。异或运算满足交换律和结合律，相同数字异或为0，0异或任何数等于该数。
 * 遍历数组将所有数字异或，最终结果即为只出现一次的数字。
 * 时间复杂度：O(n)，空间复杂度：哈希表O(n)，异或O(1)。
 */
public class LC_136 {
    // 哈希表
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            if (set.contains(num)){
                set.remove(num);
            }else {
                set.add(num);
            }
        }
        return set.iterator().next();
    }
    // 异或运算
    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int num: nums){
            ans = ans ^ num; // xor
        }
        return ans;
    }
}
