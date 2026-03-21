import java.util.ArrayList;
import java.util.List;

public class LC_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracing(ans, new ArrayList<>(), candidates, target, 0, 0);
        return ans;
    }

    private void backTracing(List<List<Integer>> ans, List<Integer> oneAns,int[] candidates, int target, int sum, int cur){
        if (sum > target) return;
        if (sum == target){
            ans.add(new ArrayList<>(oneAns));
            return;
        }
        for (int i = cur; i < candidates.length; i++){
            // 选，加入结果
            oneAns.add(candidates[i]);
            // 递归，当前元素还能选，这里cur传i，因为
            backTracing(ans, oneAns, candidates, target, sum + candidates[i], i);
            // 撤销，不选
            oneAns.remove(oneAns.size() - 1);
        }
    }
}
