import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC_56 {
    public int[][] merge(int [][] intervals){
        //按照数组的左区间排序
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for (int[] interval: intervals){
            if (interval[0] <= ans.get(ans.size() - 1)[1]){
                ans.get(ans.size() - 1)[1] = Math.max(interval[1], ans.get(ans.size() - 1)[1]);
            }
            else{
                ans.add(interval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
