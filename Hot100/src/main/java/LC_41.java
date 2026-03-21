public class LC_41 {
    public int firstMissingPositive(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len; i++){
            while(0 < nums[i] && nums[i] <= len && nums[nums[i] - 1] != nums[i]){
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < len; i++){
            if(nums[i] != i + 1){
                if(i == 0){
                    return 1;
                }else {
                    return nums[i - 1] + 1;
                }
            }
        }
        return nums[len - 1] + 1;
    }
}
