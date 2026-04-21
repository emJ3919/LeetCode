import java.util.ArrayList;
import java.util.List;

/**
 * 题目：二叉树展开为链表
 * 思路：
 * 方法1：前序遍历，将遍历结果存入列表，再遍历列表重新连接成链表，左指针置空，右指针指向下一个节点。
 * 时间复杂度：O(n)，空间复杂度：O(n)。
 * 方法2：原地处理，从根节点开始，若左子树不为空，找到左子树的最右节点，将右子树接到最右节点，
 *        然后将左子树移到右边，左指针置空，继续处理下一个节点。
 * 时间复杂度：O(n)，空间复杂度：O(1)。
 */
public class LC_114 {
    // 方法1：前序遍历
    public void solution1(TreeNode root){
        // 初始化列表记录中序遍历顺序
        List<TreeNode> tmpNodes = new ArrayList<>();
        preorder(root, tmpNodes);
        // 再次遍历数组，重新连接（列表中存的是地址）
        for (int i = 0; i < tmpNodes.size() - 1; i++){
            tmpNodes.get(i).left = null;
            tmpNodes.get(i).right = tmpNodes.get(i + 1);
        }
    }
    private void preorder(TreeNode root, List<TreeNode> list){
        if (root != null){
            list.add(root);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }

    // 方法2：原地处理
    public void solution2(TreeNode root){
        TreeNode cur = root;
        while (cur != null){
            if (cur.left != null) {// 左子树不为空才处理
                // 找到左子树的最右节点
                TreeNode pre = cur.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 将右子树接到左子树的最右节点
                pre.right = cur.right;
                // 将左子树移到右边
                cur.right = cur.left;
                // 左指针置空
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
