import sun.reflect.generics.tree.Tree;

public class LC_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 第一个为根节点
        return buildMyTree(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode buildMyTree(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR){
        if (preL > preR) return null;
        // 创建根节点
        TreeNode node = new TreeNode(preorder[preL]);
        int mid = preL;
        // 遍历中序数组，根节点就将其分为了左右子树两部分
        for (int i = inL; i <= inR; i++){
            if (inorder[i] == preorder[preL]){
                mid = i;
                break;
            }
        }
        int leftSize = mid - inL;
        // preorder[]: 左半部分[preL + 1, preL + mid - inL] 右半部分[preL + mid - inL + 1, preR]
        // inorder[]: 左 [inL, mid - 1] 右 [mid + 1, inR]
        node.left = buildMyTree(preorder, inorder, preL + 1, preL + leftSize, inL, mid - 1);
        node.right = buildMyTree(preorder, inorder, preL + leftSize + 1, preR, mid + 1, inR);
        return node;
    }
}
