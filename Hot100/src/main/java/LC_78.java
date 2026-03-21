import java.util.ArrayList;
import java.util.List;

public class LC_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> oneAns = new ArrayList<>();
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
