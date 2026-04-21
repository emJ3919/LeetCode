import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 题目：最长连续序列
 * 思路：把数组放入HashSet去重。然后遍历数组，以当前数为起点开始往后数。
 *       因为如果num-1存在，那num就不是起点，会被跳过，避免重复计算。
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class LC_128 {
    public int longestConsecutive(int[] nums) {
        // 记录最长长度
        int max = 0;
        // 用set去重，加快查找
        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }
        for (int num: set){
            // 判断是否存在前序，存在就不用判断了，说明之前已经记录过这个长度了
            if (!set.contains(num - 1)){
                // 记录以当前字符为起点的字符串最长长度
                int currentNum = num;
                int currentLength = 1;
                // 找后序
                while (set.contains(currentNum + 1)){
                    currentLength++;
                    currentNum++;
                }
                // 更新最大长度
                max = Math.max(max, currentLength);
            }
        }
        return max;
    }
}
