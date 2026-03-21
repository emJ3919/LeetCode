import java.util.Deque;
import java.util.LinkedList;

public class LC_230 {
    public int kthSmallest(TreeNode root, int k){
        // 初始化栈
        Deque<TreeNode> dq = new LinkedList<>();
        // while循环到root为null（树遍历完了）|| 栈不为空（节点还没计算完，没出完）
        while (root != null || !dq.isEmpty()){
            // 左边先入栈
            while (root != null){
                dq.push(root);
                root = root.left;
            }
            // 到达当前的最左,弹出当前的节点，放在root，后面继续循环右子树。
            root = dq.pop();
            k -= 1;
            // 到达第k个
            if (k == 0){
                return root.val;
            }
            // 循环右边
            root = root.right;
        }
        return root.val;
    }
}
