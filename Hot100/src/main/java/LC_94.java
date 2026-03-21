import java.util.*;

public class LC_94 {
    public List<Integer> inorderTraversal(TreeNode root){
        // 初始结果数组
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    // void就好，会直接修改传入的ans
    private void helper(TreeNode root, List<Integer> ans){
        if(root == null) return;
        helper(root.left, ans);
        // 到这一步左子树就已经完全记录了，所以记录当前节点的值就行了。
        ans.add(root.val);
        helper(root.right, ans);
    }
}
