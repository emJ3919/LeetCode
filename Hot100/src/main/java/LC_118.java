import java.util.ArrayList;
import java.util.List;

public class LC_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            // 存一行的数据
            List<Integer> oneAns = new ArrayList<>();
            for (int j = 0; j <= i; j ++){
                // 每行的第一个和最后一个
                if (j == 0 || j == i){
                    oneAns.add(1);
                }else {
                    oneAns.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
                }
            }
            ans.add(oneAns);
        }
        return ans;
    }
}
