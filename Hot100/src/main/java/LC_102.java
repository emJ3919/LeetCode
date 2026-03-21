import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC_102 {
    public List<List<Integer>> levelOrder(TreeNode root){
        if(root == null) return new ArrayList<>();
        // 初始化队列
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        // 初始化节点数组
        List<List<Integer>> ans = new ArrayList<>();
        // 弹出根节点，孩子节点入队
        while (!dq.isEmpty()){
            // 记录该层结果
            List<Integer> levelAns = new ArrayList<>();
            int levelSize = dq.size();
            // 弹出这一层的所有节点
            for (int i = 0; i < levelSize; i++){
                TreeNode tmpNode = dq.poll();
                levelAns.add(tmpNode.val);
                if (tmpNode.left != null){
                    dq.offer(tmpNode.left);
                }
                if (tmpNode.right != null){
                    dq.offer(tmpNode.right);
                }
            }
            // 该层节点加入结果
            ans.add(levelAns);
        }
        return ans;
    }
}
