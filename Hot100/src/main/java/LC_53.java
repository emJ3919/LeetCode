public class LC_53 {
    public int maxSubArray(int[] nums){
        int max = nums[0];
        int pre_sum = 0;
        for (int num: nums){
            max = Math.max(max, pre_sum + num);
            pre_sum += num;
            if(pre_sum < 0){
                pre_sum = 0;
            }
        }
        return max;
    }
}
