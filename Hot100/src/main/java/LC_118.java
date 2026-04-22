import java.util.ArrayList;
import java.util.List;

/**
 * 题目：杨辉三角
 * 思路：动态规划。
 * 每行的第一个和最后一个元素都是1。
 * 中间的元素等于上一行相邻两个元素之和。
 * 根据这个规律依次生成每一行。
 * 时间复杂度：O(n²)，空间复杂度：O(1)。
 */
public class LC_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            // 存一行的数据
            List<Integer> oneAns = new ArrayList<>();
            for (int j = 0; j <= i; j ++){
                // 每行的第一个和最后一个就是1
                if (j == 0 || j == i){
                    oneAns.add(1);
                }else { // 上一行的两个元素（j-1和j）之和
                    oneAns.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
                }
            }
            ans.add(oneAns);
        }
        return ans;
    }
}
