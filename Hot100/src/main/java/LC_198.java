public class LC_198 {
    public int rob(int[] nums) {
        int len = nums.length;
        // 处理小于三个房间的情况
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        // 记录偷到前两间房能获取的最大价值
        int pre2 = nums[0];
        int pre = Math.max(nums[0], nums[1]);
        // 遍历计算后面房间，这里从三号房间开始，i=2
        for (int i = 2; i < len; i++){
            // 下一轮变为pre2
            int tmp = pre;
            pre = Math.max(pre, pre2 + nums[i]);
            pre2 = tmp;
        }
        return pre;
    }
}
