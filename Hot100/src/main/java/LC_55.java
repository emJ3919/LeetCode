public class LC_55 {
    public boolean canJump(int[] nums){
        // 记录前面能到的最远位置下标
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > maxJump) return false; // 说明跳不到这里
            maxJump = Math.max(maxJump, i + nums[i]); // 前面能到达的最远和这里能到达的最远位置取最大（也就是选择是否从这里跳）
            if (maxJump >= nums.length - 1) return true; // 已经能跳到最远的位置了，直接返回true;
        }
        // 空数组情况
        return false;
    }
}
