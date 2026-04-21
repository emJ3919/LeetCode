import java.util.ArrayList;
import java.util.List;

/**
 * 题目：组合总和
 * 思路：回溯。
 * 数组中的数字可以重复使用，目标是从数组中选若干数字使和等于目标值。
 * 从索引cur开始遍历数组，选中则加入结果并累加和，由于元素可重复，递归时传i而非i+1。
 * 若和大于目标值则剪枝返回，等于目标值则将结果加入答案列表。
 * 递归完成后撤销选择，尝试下一个数字。
 * 时间复杂度：O(n!)，空间复杂度：O(target)。
 */
public class LC_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracing(ans, new ArrayList<>(), candidates, target, 0, 0);
        return ans;
    }

    private void backTracing(List<List<Integer>> ans, List<Integer> oneAns,
        int[] candidates, int target, int sum, int cur){
        if (sum > target) return;
        if (sum == target){
            ans.add(new ArrayList<>(oneAns));
            return;
        }
        for (int i = cur; i < candidates.length; i++){
            // 选，加入结果
            oneAns.add(candidates[i]);
            // 递归，因为当前元素还能选，这里cur传i
            backTracing(ans, oneAns, candidates, target, sum + candidates[i], i);
            // 撤销，不选
            oneAns.remove(oneAns.size() - 1);
        }
    }
}
