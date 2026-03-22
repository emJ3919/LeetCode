import java.util.ArrayDeque;
import java.util.Deque;

public class LC_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++){
            // 栈为空或者栈顶元素大入栈
            if (dq.isEmpty() || temperatures[dq.peek()] >= temperatures[i]){
                // 索引入栈
                dq.push(i);
            }
            // 当前温度比栈顶大
            else{
                // 出栈所有小的，因为这是他们的下一个最高温度了,一直出栈到栈顶更大
                while (!dq.isEmpty() && temperatures[dq.peek()] < temperatures[i]){
                    int pre = dq.pop();
                    ans[pre] = i - pre;
                }
                // 当前入栈
                dq.push(i);
            }
        }
        return ans;
    }
}
