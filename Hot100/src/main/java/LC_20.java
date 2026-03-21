import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
