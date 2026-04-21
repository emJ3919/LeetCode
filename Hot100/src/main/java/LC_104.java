/**
 * 题目：二叉树的最大深度
 * 思路：递归。
 * 最大深度 = 左右子树最大深度的较大值 + 1（当前节点层）。
 * 递归处理左右子树，返回较大深度并加一。
 * 时间复杂度：O(n)，空间复杂度：O(h)，h为树的高度（递归栈深度）。
 */
public class LC_104 {
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        // 递归处理左子树深度
        int l_max = maxDepth(root.left);
        // 递归处理右子树深度
        int r_max = maxDepth(root.right);
        // 左右子树的最大深度 + 1 （当前高度）
        return Math.max(l_max, r_max) + 1;
    }
}
