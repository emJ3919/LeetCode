/**
 * 题目：多数元素
 * 思路：摩尔投票法。
 * 候选人票数初始化为0，遍历数组，当前票数为0时将当前数设为候选人。
 * 若当前数等于候选人则票数加一，否则票数减一。
 * 由于多数元素出现次数超过一半，最后留下的候选人即为多数元素。
 * 时间复杂度：O(n)，空间复杂度：O(1)。
 */
public class LC_169 {
    // 投票
    public int majorityElement(int[] nums) {
        // 选择的数字，对应的票数
        int[] ans = {0,0};
        int target = nums.length/2;
        for (int num: nums){
            if (ans[1] > target) return ans[0]; // 剪枝
            if (ans[1] == 0){// 当前没有候选者，当前数字为候选者
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
