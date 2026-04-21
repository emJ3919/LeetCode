import java.util.*;

/**
 * 题目：字母异位词分组
 * 思路：字母异位词只是字符顺序不同，排序后结果相同。
 *       遍历每个字符串，排序后作为map的key，相同key的归为一组。
 * 时间复杂度：O(n * klogk)，空间复杂度：O(n * k)
 */

public class LC_49 {
    public List<List<String>> groupAnagrams(String[] strs){
        // map存字符组和对应的结果集
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str: strs){
            // 将字符串拆为字符数组
            char[] chars = str.toCharArray();
            // 排序
            Arrays.sort(chars);
            // 排序后的字符设置为key
            String key = new String(chars);
            // 获取这个字符组的结果集
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            // 当前的加进去
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}

