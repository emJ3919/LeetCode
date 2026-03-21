import java.util.Stack;

public class LC_42 {

    //双指针
    public int solution1(int[] height){
        //初始化记录结果、左右指针、左右最大值
        int sum = 0;
        int l_max = height[0];
        int r_max = height[height.length - 1];
        //第一列和最后一列不会装水，所以不用计算
        int l = 1;
        int r = height.length - 2;
        //计算指针位置的水量，竖着算，相遇的时候也需要算一轮
        while(l <= r){
            //水量由左右左右最大值矮的那个决定。
            if(height[l - 1] <= height[r + 1]){
                if(height[l] > l_max){
                    //更新左边界最大值
                    l_max = height[l];
                    l++;
                    continue;
                }
                sum += l_max - height[l];
                l++;
            }
            else{
                if(height[r] > r_max){
                    r_max = height[r];
                    r--;
                    continue;
                }
                sum += r_max - height[r];
                r--;
            }
        }
        return sum;
    }

    //单调栈
    public int solution2(int[] height){
        int sum = 0;
        //单调栈，递减，记录下标
        Stack<Integer> stack = new Stack<>();
        //遍历高度数组，进行入栈和计算
        for (int i = 0; i < height.length; i++){
            //当当前位置的高度比栈顶高，且栈里面有两个以上元素，说明形成了凹陷，可以接雨水。
            // 用while循环分层计算。
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                //栈里面只有一个元素，没用了，直接弹出之后遍历下一个。
                if(stack.isEmpty()){
                    break;
                }
                //获得下左边界的下标，这里不弹出，因为等会儿还会计算前面的。
                int left = stack.peek();
                //横着算
                int x = i - left - 1;
                //当左边高度和当前计算位置高度相同的时候就为0了
                int y = Math.min(height[i], height[left]) - height[top];
                sum += x * y;
            }
            stack.push(i);
        }
        return sum;
    }

}
