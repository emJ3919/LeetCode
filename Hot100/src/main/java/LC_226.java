public class LC_226 {
    public TreeNode invertTree(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode lTree = invertTree(root.left);
        TreeNode rTree = invertTree(root.right);
        root.left = rTree;
        root.right = lTree;
        return root;
    }
}
