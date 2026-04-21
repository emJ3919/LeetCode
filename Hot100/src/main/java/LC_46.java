import java.util.ArrayList;
import java.util.List;

/**
 * 题目：全排列
 * 思路：回溯。
 * 用数组记录每个数字是否被使用过。
 * 从第一个数字开始，遍历所有数字，将未使用的数字加入当前结果，进行递归。
 * 递归完成后撤销选择（回溯），尝试下一个数字。
 * 当当前结果长度等于数组长度时，将结果加入答案列表。
 * 时间复杂度：O(n!)，空间复杂度：O(n)。
 */
public class LC_46 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 记录数字是否被使用
        boolean[] used = new boolean[len];
        // 记录结果
        List<List<Integer>> ans = new ArrayList<>();
        // 记录子结果
        List<Integer> oneAns = new ArrayList<>();
        backTracing(nums, used, ans, oneAns, len);
        return ans;
    }

    private void backTracing(int[] nums, boolean[] used, List<List<Integer>> ans, List<Integer> oneAns, int len){
        // 这一个结果遍历完毕
        if (oneAns.size() == len){
            ans.add(new ArrayList<>(oneAns));
            return;
        }
        // 遍历加入没使用的数字
        for (int i = 0; i < len; i++){
            if (!used[i]){
                // 加入当前结果集，更新使用状态，进行下次递归
                oneAns.add(nums[i]);
                used[i] = true;
                backTracing(nums, used, ans, oneAns, len);
                // 撤销当前结果
                oneAns.remove(oneAns.size() - 1);
                used[i] = false;
            }
        }
    }
}
