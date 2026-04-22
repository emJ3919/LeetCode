import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 题目：最小栈
 * 思路：辅助栈。
 * 入栈时维护一个最小栈，记录当前栈中的最小值。
 * 每次入栈时，最小栈记录当前最小值（当前元素与最小栈栈顶的较小值）。
 * 出栈时两个栈同时弹出。
 * 获取最小值直接返回最小栈栈顶元素。
 * 时间复杂度：O(1)，空间复杂度：O(n)。
 */
public class LC_155 {
    class MinStack{
        List<Integer> stack;
        List<Integer> minStack;
        public MinStack(){
            this.stack = new ArrayList<>();
            this.minStack = new ArrayList<>();
        }
        // 入栈
        public void push(int val){
            // 入主栈
            stack.add(val);
            // 最小栈，注意要用isEmpty判断是否为空
            if (minStack.isEmpty()){
                minStack.add(val);
            }else {
                // 与最小栈栈顶元素比较
                // 当前元素更小，入栈更新栈顶更小
                if (val <= minStack.get(minStack.size() - 1)){
                    minStack.add(val);
                }
                // 栈内有更小的，复制栈顶
                else {
                    minStack.add(minStack.get(minStack.size() - 1));
                }
            }
        }
        // 出栈
        public void pop(){
            stack.remove(stack.size() - 1);
            minStack.remove(minStack.size() - 1);
        }
        // 获取栈顶
        public int top(){
            return stack.get(stack.size() - 1);
        }
        // 获取最小
        public int getMin(){
            return minStack.get(minStack.size() - 1);
        }
    }
}
