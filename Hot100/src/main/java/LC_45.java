/**
 * 题目：跳跃游戏 II
 * 思路：贪心。
 * 用两个变量记录当前跳能到的最远位置和下一跳能到的最远位置。
 * 遍历数组，更新下一跳能到的最远位置。
 * 当到达当前跳的边界时说明需要再跳一次，更新当前跳为下一跳能到的最远位置，跳跃次数加一。
 * 若当前跳已能达到末尾则提前结束。
 * 时间复杂度：O(n)，空间复杂度：O(1)。
 */
public class LC_45 {
    public int jump(int[] nums) {
        int len = nums.length;
        // 当前能到的最远位置
        int thisJump = 0;
        // 下一跳能到达的最远距离
        int nextJump = 0;
        // 到最远位置跳的次数
        int step = 0;
        for (int i = 0; i < len; i++){
            if (thisJump >= len - 1) break; // 已经能到终点了
            // 先更新下次能跳到的最远位置，因为如果到这次跳的边界了需要用到
            nextJump = Math.max(nextJump, i + nums[i]);
            // 当前已经到现在的边界
            if (i == thisJump){
                // 起跳，起跳能到这个区间更新的最远位置
                thisJump = nextJump;
                step++;
            }
        }
        return step;
    }
}
