import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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
        // 构建优先队列（本质是堆），比较value。存的是key，入队的时候比较的是valve
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
