import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：二叉搜索树中第K小的元素
 * 思路：中序遍历。
 * 二叉搜索树中序遍历结果是升序的，第k小的元素即中序遍历的第k个节点。
 * 方法1：递归中序遍历，先递归左子树，访问根节点时计数器加一，达到k时记录结果并返回，再递归右子树。
 * 方法2：栈实现中序遍历，将左子树节点依次入栈，弹出节点时计数减一，达到k返回，然后遍历右子树。
 * 时间复杂度：O(n)，空间复杂度：O(h)。
 */
public class LC_230 {
    int count = 0;  // 记录当前已经遍历了几个节点
    int result = 0; // 记录最终找到的那个答案
    public int kthSmallest(TreeNode root, int k){ // 方法1
        helper(root, k);
        return result;
    }
    // 递归实现中序遍历
    private void helper(TreeNode root, int k) {
        // 递归出口，剪枝
        if (root == null || count >= k) {
            return;
        }
        // 左
        helper(root.left, k);
        // 根
        count++; // 走到了一个节点，计数器 +1
        if (count == k) {
            result = root.val; // 找到第 k 个了
            return;            // 记录完可以返回了
        }
        // 右
        helper(root.right, k);
    }

    // 栈实现中序遍历
    public int kthSmallest2(TreeNode root, int k){ // 方法2
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
