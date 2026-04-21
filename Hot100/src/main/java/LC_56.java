import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：合并区间
 * 思路：按左边界排序后贪心合并。
 * 对区间按左边界排序，遍历时与结果中最后一个区间比较。
 * 若当前区间左边界 <= 上个区间右边界，则合并（取右边界较大值）。
 * 否则为无交集的新区间，直接加入结果。
 * 时间复杂度：O(n log n)，空间复杂度：O(n)
 */
public class LC_56 {
    public int[][] merge(int [][] intervals){
        //按照数组的左区间排序，方便后续合并比较
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 记录合并后的区间，第一个区间直接加入
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for (int[] interval: intervals){
            // 当前区间与上一个区间（答案的最后一个区间）有交集
            if (interval[0] <= ans.get(ans.size() - 1)[1]){
                // 合并：更新区间右边界为最大值
                ans.get(ans.size() - 1)[1] = Math.max(interval[1], ans.get(ans.size() - 1)[1]);
            }
            // 当前区间与上一个区间无交集，说明是新区间
            else{
                ans.add(interval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
