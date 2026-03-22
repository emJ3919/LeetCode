import java.util.Deque;
import java.util.LinkedList;

public class LC_394 {
    public String decodeString(String s) {
        // 字符串栈，存待解码的数，从上到下的顺序解码
        Deque<StringBuilder> strStack = new LinkedList<>();
        // 数字栈，存解码的倍数
        Deque<Integer> numStack = new LinkedList<>();
        // 记录结果，永远表示准备解码的数
        StringBuilder currentStr = new StringBuilder();
        // 用于计算连续数字
        int num = 0;
        // 扫描一遍即可
        for (int i = 0; i < s.length(); i++) {
            // 当前位置是数字
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                // 前面的数字进位
                num = num * 10 + s.charAt(i) - '0';
            }
            // 左括号，说明倍数记录完，且当前准备解码的要入栈，因为到这之后要解码的是'['后面的了
            else if (s.charAt(i) == '['){
                numStack.push(num);
                strStack.push(currentStr);
                // 清空
                num = 0;
                // 新建一个，因为栈里面存了这个的地址
                currentStr = new StringBuilder();
            }
            // 右括号，说明当前已经可以解码，解码后将栈的弹出并拼在前面，准备下一次解码
            else if (s.charAt(i) == ']'){
                // 解码
                int times = numStack.pop();
                String str = currentStr.toString();
                for (int j = 1; j < times; j++){
                    currentStr.append(str);
                }
                // 出栈，拼接
                currentStr = strStack.pop().append(currentStr);
            }
            // 遍历添加待解码字符串
            else {
                currentStr.append(s.charAt(i));
            }
        }
        return currentStr.toString();
    }
}
