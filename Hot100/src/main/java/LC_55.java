/**
 * 题目：跳跃游戏
 * 思路：贪心。
 * 维护一个变量记录前面能到达的最远位置下标。
 * 遍历数组，若当前位置超过最远位置说明跳不到，返回false。
 * 更新最远位置为当前位置能跳到的最远处与历史最远的较大值。
 * 若最远位置已达到数组末尾则返回true。
 * 时间复杂度：O(n)，空间复杂度：O(1)。
 */
public class LC_55 {
    public boolean canJump(int[] nums){
        // 记录前面能到的最远位置下标
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++){
            // 说明跳不到这里
            if (i > maxJump) return false; 
            // 前面能到达的最远和从这里起跳能到达的最远位置取最大
            maxJump = Math.max(maxJump, i + nums[i]); 
            // 已经能跳到最远的位置了，直接返回true;
            if (maxJump >= nums.length - 1) return true; 
        }
        // 空数组情况
        return false;
    }
}
