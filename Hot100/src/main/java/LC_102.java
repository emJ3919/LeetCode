import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：二叉树的层序遍历
 * 思路：队列BFS。
 * 使用队列存储节点，每层节点依次弹出，将其值加入当前层结果。
 * 将弹出节点的左右子节点加入队列，循环直到队列为空。
 * 时间复杂度：O(n)，空间复杂度：O(n)。
 */
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
            // 记录当前层节点数
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
