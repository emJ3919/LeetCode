import java.util.ArrayList;
import java.util.List;

/**
 * 题目：子集
 * 思路：回溯。
 * 对于每个位置，都有选择和不选择两种情况。
 * 从第一个位置开始，递归处理选择当前数和不选择当前数两种分支。
 * 当处理到数组末尾时，将当前结果加入答案列表。
 * 时间复杂度：O(2^n)，空间复杂度：O(n)。
 */
public class LC_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> oneAns = new ArrayList<>();
        // cur 代表当前选择位置
        backTracing(nums, ans, oneAns, 0);
        return ans;
    }

    private void backTracing(int[] nums, List<List<Integer>> ans, List<Integer> oneAns, int cur){
        // 每个数都选择完毕
        if (cur == nums.length){
            ans.add(new ArrayList<>(oneAns));
            return;
        }
        // 选择当前数
        oneAns.add(nums[cur]);
        // 下次递归选择的位置
        cur++;
        // 递归选择当前数的分支
        backTracing(nums, ans, oneAns, cur);
        // 不选择当前数
        oneAns.remove(oneAns.size() - 1);
        backTracing(nums, ans, oneAns, cur);
    }
}
