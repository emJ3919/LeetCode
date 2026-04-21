/**
 * 题目：二叉树的直径
 * 思路：递归。
 * 对于每个节点，经过该节点的最长路径 = 左子树深度 + 右子树深度。
 * 用全局变量记录最大直径，递归返回当前子树的最大深度。
 * 时间复杂度：O(n)，空间复杂度：O(h)，h为树的高度（递归栈深度）。
 */
public class LC_543 {
    // 最大直径
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root){
        helper(root);
        return max;
    }
    private int helper(TreeNode root){
        if(root == null) return 0;
        // 递归左子树最大深度
        int l_max = helper(root.left);
        // 递归右子树最大深度
        int r_max = helper(root.right);
        // 更新最大值
        max = Math.max(max, l_max + r_max);
        // 返回当前子树最大深度
        return 1 + Math.max(l_max, r_max);
    }
}
