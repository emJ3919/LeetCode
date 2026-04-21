import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：二叉树的右视图
 * 思路：层序遍历。
 * 使用队列进行层序遍历，每层依次弹出节点。
 * 每层的最后一个节点就是从右侧看到的节点，将其值加入结果。
 * 时间复杂度：O(n)，空间复杂度：O(n)。
 */
public class LC_199 {
    public List<Integer> rightSideView(TreeNode root){
        if (root == null) return new ArrayList<>();
        // 用于层序遍历
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        // 用于存储结果
        List<Integer> ans = new ArrayList<>();
        while (!dq.isEmpty()){
            // 每层节点数
            int n = dq.size();
            // 遍历当前层的所有节点
            for(int i = 0; i < n; i++){
                TreeNode tmp = dq.poll();
                // 这是当前层的最后一个节点，记录结果
                if(i == n - 1){
                    ans.add(tmp.val);
                }
                // 左右子树入队
                if(tmp.left != null) dq.offer(tmp.left);
                if(tmp.right != null) dq.offer(tmp.right);
            }
        }
        return ans;
    }
}
