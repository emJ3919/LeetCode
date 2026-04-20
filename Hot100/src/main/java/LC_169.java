public class LC_169 {
    // 投票
    public int majorityElement(int[] nums) {
        // 选择的数字，对应的票数
        int[] ans = {0,0};
        int target = nums.length/2;
        for (int num: nums){
            if (ans[1] > target) return ans[0]; // 剪枝
            if (ans[1] == 0){// 当前没有候选者
                ans[0] = num;
            }
            if (ans[0] == num){// 相同加票，不同减票
                ans[1] += 1;
            }else {
                ans[1] -= 1;
            }
        }
        return ans[0];
    }
}
