/**
 * 题目：翻转二叉树
 * 思路：递归。
 * 递归处理左右子树，交换每个节点的左右子树。
 * 返回交换后的根节点。
 * 时间复杂度：O(n)，空间复杂度：O(h)，h为树的高度（递归栈深度）。
 */
public class LC_226 {
    public TreeNode invertTree(TreeNode root){
        if (root == null){
            return null;
        }
        // 递归处理左子树
        TreeNode lTree = invertTree(root.left);
        // 递归处理右子树
        TreeNode rTree = invertTree(root.right);
        // 交换左右子树
        root.left = rTree;
        root.right = lTree;
        return root;
    }
}
