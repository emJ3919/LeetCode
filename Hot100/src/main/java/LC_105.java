
/**
 * 题目：从前序与中序遍历序列构造二叉树
 * 思路：递归。
 * 前序遍历的第一个元素是根节点，在中序遍历中找到该根节点，其左侧为左子树，右侧为右子树。
 * 根据中序遍历中左子树的长度，可以确定前序遍历中左子树和右子树的区间范围。
 * 递归构建左子树和右子树，返回根节点。
 * 时间复杂度：O(n)，空间复杂度：O(log n)，log n为递归栈深度。
 */
public class LC_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 传入前序中序数组以及区间范围
        return buildMyTree(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }
    // preL：前序的左闭区间（根节点），preR：前序的右闭区间
    // inL：中序的左闭区间，inR：中序的右闭区间
    private TreeNode buildMyTree(int[] preorder, int[] inorder,
        int preL, int preR, int inL, int inR){
        if (preL > preR) return null;
        // 创建根节点
        TreeNode node = new TreeNode(preorder[preL]);
        // 根节点在中序数组中的位置
        int mid = inL;
        // 遍历中序数组，根节点就将其分为了左右子树两部分
        for (int i = inL; i <= inR; i++){
            // 找到根节点在中序数组中的位置
            if (inorder[i] == preorder[preL]){
                mid = i;
                break;
            }
        }
        // 左子树的大小
        int leftSize = mid - inL;
        // preorder[]: 左半部分[preL + 1, preL + leftSize] 右半部分[preL +leftSize + 1, preR]
        // inorder[]: 左 [inL, mid - 1] 右 [mid + 1, inR]
        node.left = buildMyTree(preorder, inorder, preL + 1, preL + leftSize, inL, mid - 1);
        node.right = buildMyTree(preorder, inorder, preL + leftSize + 1, preR, mid + 1, inR);
        return node;
    }
}
