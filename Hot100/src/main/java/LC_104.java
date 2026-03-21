public class LC_104 {
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        int l_max = maxDepth(root.left);
        int r_max = maxDepth(root.right);
        // 左右子树的最大深度 + 1 （当前高度）
        return Math.max(l_max, r_max) + 1;
    }
}
