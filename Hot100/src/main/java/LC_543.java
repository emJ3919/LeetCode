public class LC_543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root){
        helper(root);
        return max;
    }
    private int helper(TreeNode root){
        if(root == null) return 0;
        int l_max = helper(root.left);
        int r_max = helper(root.right);
        // 更新最大值
        max = Math.max(max, l_max + r_max);
        // 返回当前子树最大深度
        return 1 + Math.max(l_max, r_max);
    }
}
