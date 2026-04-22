import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：划分字母区间
 * 思路：贪心。
 * 用哈希表记录每个字母最后出现的位置。
 * 遍历字符串，维护当前区间的最远边界（该区间内所有字母最后出现位置的最大值）。
 * 当遍历到最远边界时说明该区间内的字母不会再出现在后面，可以切分。
 * 时间复杂度：O(n)，空间复杂度：O(1)。
 */
public class LC_763 {
    public List<Integer> partitionLabels(String s) {
        // 哈希表记录字母出现的最后位置
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++){
            map.put(s.charAt(i), i);
        }
        int min = 0; // 当前切分所需的最短位置
        int pre = -1; // 记录上次切分位置
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++){
            // 根据最后出现的位置计算当前最短切分位置
            min = Math.max(min, map.get(s.charAt(i)));
            // 当前达到切分位置
            if (i == min){
                // 切分，计算当前切分长度
                ans.add(i - pre);
                pre = i;
//min = 0; // 重置切分位置，不需要重置，因为切分后下次必定会更长。
            }
        }
        return ans;
    }
}
