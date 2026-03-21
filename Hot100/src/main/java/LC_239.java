import java.util.ArrayDeque;
import java.util.Deque;

public class LC_239 {
    public int[] maxSlidingWindow(int[] nums, int k){
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++){
            //新元素入队，清理弱元素
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            //当前元素入队
            dq.offer(i);
            //检验队头是否超出窗口
            if(dq.peek() <= i - k){
                dq.poll();
            }
            //i的位置达到窗口长度，说明窗口初始化完成，开始计算结果。
            if(i >= k - 1){
                ans[i - k  + 1] = nums[dq.peek()];
            }
        }
        return ans;
    }
}
