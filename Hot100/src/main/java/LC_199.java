import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC_199 {
    public List<Integer> rightSideView(TreeNode root){
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        List<Integer> ans = new ArrayList<>();
        while (!dq.isEmpty()){
            int n = dq.size();
            for(int i = 0; i < n; i++){
                TreeNode tmp = dq.poll();
                if(i == n - 1){
                    ans.add(tmp.val);
                }
                if(tmp.left != null) dq.offer(tmp.left);
                if(tmp.right != null) dq.offer(tmp.right);
            }
        }
        return ans;
    }
}
