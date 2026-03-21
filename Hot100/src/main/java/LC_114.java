import java.util.ArrayList;
import java.util.List;

public class LC_114 {
    public void flatten(TreeNode root){
        // 初始化列表记录中序遍历顺序
        List<TreeNode> tmpNodes = new ArrayList<>();
        preorder(root, tmpNodes);
        // 再次遍历数组，重新连接（列表中存的是地址）
        for (int i = 0; i < tmpNodes.size() - 1; i++){
            tmpNodes.get(i).left = null;
            tmpNodes.get(i).right = tmpNodes.get(i + 1);
        }
    }
    // 中序遍历
    private void preorder(TreeNode root, List<TreeNode> list){
        if (root != null){
            list.add(root);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }

    public void solution2(TreeNode root){
        TreeNode cur = root;
        while (cur != null){
            if (cur.left != null) {
                // 左子树不为空才处理：找到左子树的最右节点
                TreeNode pre = cur.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
