import java.util.Deque;
import java.util.LinkedList;

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

    // 建树，要用Integer传入，因为需要存null
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
            // 连接右孩子
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

