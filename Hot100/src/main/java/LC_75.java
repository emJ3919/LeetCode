public class LC_75 {
    public void sortColors(int[] nums) {
        int p0 = 0; // 0的右边界:下一个0的位置
        int p2 = nums.length - 1; // 2的左边界：下一个2的位置
        int cur = 0; // 当前遍历的位置
        // 遍历条件应该是当前遍历到了p2的左边界
        while (cur <= p2){
            if (nums[cur] == 0){ // 0放在p0并更新p0
                // 交换
                int tmp = nums[cur];
                nums[cur] = nums[p0];
                nums[p0] = tmp;
                // 移动
                p0++;
                cur++;
            }else if (nums[cur] == 2){ // 2放在p2
                int tmp = nums[cur];
                nums[cur] = nums[p2];
                nums[p2] = tmp;
                // 这里cur不能动，因为换回来的是没判断过的。
                p2--;
            } else { // 1不用操作
                cur++;
            }
        }
    }
}
