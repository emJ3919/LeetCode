/**
 * 题目：对称二叉树
 * 思路：递归。
 * 比较左子树的左节点与右子树的右节点是否相等，左子树的右节点与右子树的左节点是否相等。
 * 递归终止条件：节点为空，或值不相等。
 * 时间复杂度：O(n)，空间复杂度：O(h)，h为树的高度（递归栈深度）。
 */
public class LC_101 {
    public boolean isSymmetric(TreeNode root){
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode left, TreeNode right){
        // 结束条件，null || 不对称
        // 存在null
        if (left == null || right ==null) return left == right;
        // 值不等
        if (left.val != right.val) return false;
        // 返回递归结果,
        // 判断左子树的右节点 == 右子树的左节点？
        // 以及 左子树左节点 == 右子树右节点？
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
