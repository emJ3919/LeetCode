import java.util.*;

/**
 * 题目：二叉树的中序遍历
 * 思路：递归。
 * 遍历顺序：左子树 -> 根节点 -> 右子树。
 * 递归处理左子树，访问根节点，递归处理右子树。
 * 时间复杂度：O(n)，空间复杂度：O(h)，h为树的高度（递归栈深度）。
 */
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
