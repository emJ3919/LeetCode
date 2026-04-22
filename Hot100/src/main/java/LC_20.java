import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 题目：有效的括号
 * 思路：栈。
 * 遍历字符串，左括号入栈，右括号与栈顶元素匹配。
 * 若匹配成功弹出栈顶，否则返回false。
 * 右括号出现时若栈为空，说明没有可匹配的左括号，返回false。
 * 遍历结束后若栈为空说明全部匹配成功，否则返回false。
 * 时间复杂度：O(n)，空间复杂度：O(n)。
 */
public class LC_20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        // 构建map存储关系
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for (int i = 0; i < s.length(); i++){
            // 匹配到右括号弹元素
            if (map.containsKey(s.charAt(i))){
                // 没有元素可以弹，说明出现了右括号在左括号之前的情况，false
                if (stack.isEmpty()) return false;
                // 弹出并比较
                if (stack.pop() != map.get(s.charAt(i))) return false;
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
