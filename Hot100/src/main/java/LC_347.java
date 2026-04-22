import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 题目：前 K 个高频元素
 * 思路：哈希表 + 小根堆。
 * 先用哈希表统计每个数字出现的频率。
 * 维护一个大小为k的小根堆，堆中元素按频率比较，堆顶是k个里面频率最小的。
 * 遍历哈希表，将频率更高的元素加入堆中，若堆满则弹出堆顶（频率最低的）。
 * 遍历结束后堆中即为出现频率最高的k个元素。
 * 时间复杂度：O(n log k)，空间复杂度：O(n + k)。
 */
public class LC_347 {
    public int[] topKFrequent(int[] nums, int k) {
        // 存数字 ： 频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums){
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }
        // 构建优先队列（本质是k大小的小根堆），比较value（频率）
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for (int key: map.keySet()){
            // 堆没满，直接加
            if (pq.size() < k){
                pq.add(key);
            }
            // 堆满，且当前频率更高，弹堆顶 + 入堆
            else if (map.get(key) > map.get(pq.peek())){
                // 出队(堆顶)
                pq.poll();
                pq.add(key);
            }
        }
        // 弹出队列加入结果
        int[] ans = new int[k];
        for (int i = 0; !pq.isEmpty(); i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
}
