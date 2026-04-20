public class LC_152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        // 当前位置结尾的最大和最小乘积
        int[] dpMax = new int[len];
        int[] dpMin = new int[len];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        // 记录最大值
        int max = nums[0];
        for (int i = 1; i < len; i++){
            // 计算最大值大于0乘大的，小于0乘小的
            if (nums[i] > 0){
                // 可以选择拼或者不拼
                dpMax[i] = Math.max(nums[i] * dpMax[i - 1], nums[i]);
                dpMin[i] = Math.min(nums[i] * dpMin[i - 1], nums[i]);
            }else {
                dpMin[i] = Math.min(nums[i] * dpMax[i - 1], nums[i]);
                dpMax[i] = Math.max(nums[i] * dpMin[i - 1], nums[i]);
            }
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }
}
