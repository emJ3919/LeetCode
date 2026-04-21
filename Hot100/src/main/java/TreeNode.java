import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // ***建树****
    // 要用Integer传入，因为需要存null
    public static TreeNode createTree(Integer[] nums){
        // 数组为空，直接返回
        if (nums == null || nums.length == 0) return null;
        // 初始化根节点
        TreeNode root = new TreeNode(nums[0]);
        // 使用链表结构，因为要存null
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        // 记录数组遍历位置，因为0已经创建了，所以直接初始到1的位置
        int i = 1;
        // 建树循环
        while (i < nums.length && !dq.isEmpty()){
            // 弹出队列的家长节点
            TreeNode fatherNode = dq.poll();
            // 连接左孩子
            if (nums[i] != null){
                TreeNode lNode = new TreeNode(nums[i]);
                // 入队，确定后面添加孩子的顺序。
                dq.offer(lNode);
                fatherNode.left = lNode;
            }
            i++;
            // 连接右孩子，这里也要判断i是否越界
            if(i < nums.length && nums[i] != null){
                TreeNode rNode = new TreeNode(nums[i]);
                // 入队，确定后面添加孩子的顺序。
                dq.offer(rNode);
                fatherNode.right = rNode;
            }
            i++;
        }
        return root;
    }

    // ***遍历树****
    // 层序遍历
    public List<List<Integer>> levelOrder(TreeNode root){
        if(root == null) return new ArrayList<>();
        // 初始化队列
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        // 初始化节点数组
        List<List<Integer>> ans = new ArrayList<>();
        // 弹出根节点，孩子节点入队
        while (!dq.isEmpty()){
            // 记录该层结果
            List<Integer> levelAns = new ArrayList<>();
            // 记录当前层节点数
            int levelSize = dq.size();
            // 弹出这一层的所有节点
            for (int i = 0; i < levelSize; i++){
                TreeNode tmpNode = dq.poll();
                levelAns.add(tmpNode.val);
                if (tmpNode.left != null){
                    dq.offer(tmpNode.left);
                }
                if (tmpNode.right != null){
                    dq.offer(tmpNode.right);
                }
            }
            // 该层节点加入结果
            ans.add(levelAns);
        }
        return ans;
    }

    // 前序遍历
    public void preOrder(TreeNode root){
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    public void inOrder(TreeNode root){
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    // 后序遍历
    public void postOrder(TreeNode root){
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    // 测试
    public static void main(String[] args) {
        Integer[] tree = {1,2,3,null,4};
        TreeNode root = createTree(tree);
        while (root != null){
            System.out.println(root.val);
            root = root.left;
        }
    }
}

