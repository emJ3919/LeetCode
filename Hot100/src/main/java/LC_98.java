/**
 * 题目：验证二叉搜索树
 * 思路：中序遍历。
 * 二叉搜索树的中序遍历结果是升序的。
 * 中序遍历二叉树，用变量记录遍历过的最大值，若当前节点值小于等于最大值则不合法。
 * 时间复杂度：O(n)，空间复杂度：O(h)，h为树的高度（递归栈深度）。
 */
public class LC_98 {
    // 记录之前遍历的最大值
    int max;
    // 记录是否合法
    boolean isValid = true;
    // 是否是第一次记录
    boolean notFirst = false;
    public boolean isValidBST(TreeNode root) {
        // 空或者一个节点为true
        if ( root == null || (root.right == null && root.left == null)) return true;
        inorder(root);
        return isValid;
    }
    // 中序遍历
    private void inorder(TreeNode root){
        // 剪枝：空 || 已经不合法就退
        if (root == null || !isValid) return;
        inorder(root.left);
        // 不是第一次,且当前值比前面的值小（不是升序）
        if (root.val <= max && notFirst){
            isValid = false;
        }
        notFirst = true;
        max = root.val;
        inorder(root.right);
    }
}
