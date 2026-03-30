import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_763 {
    public List<Integer> partitionLabels(String s) {
        // 哈希表记录字母出现的最后位置
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++){
            map.put(s.charAt(i), i);
        }
        int min = 0; // 当前切分的最短位置
        int pre = -1; // 记录上次切分位置
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++){
            // 更新min位置
            min = Math.max(min, map.get(s.charAt(i)));
            // 当前达到切分位置
            if (i == min){
                ans.add(i - pre);
                pre = i;
//                min = 0; // 重置切分位置，不需要重置，因为切分后下次必定会更长。
            }
        }
        return ans;
    }
}
