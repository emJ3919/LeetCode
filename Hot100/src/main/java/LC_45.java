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
                // 起跳
                thisJump = nextJump;
                step++;
            }
        }
        return step;
    }
}
