/**
 * 题目：将有序数组转换为二叉搜索树
 * 思路：递归。
 * 取中间元素作为当前子树的根节点，保证左右子树高度平衡。
 * 递归构建左子树（中间元素左侧）和右子树（中间元素右侧）。
 * 时间复杂度：O(n)，空间复杂度：O(log n)，log n为递归栈深度。
 */
public class LC_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        // 用双指针定位mid
        int l = 0;
        int r = nums.length - 1;
        return creatNode(l, r, nums);
    }

    private TreeNode creatNode(int l, int r, int[] nums){
        // 不需要创建节点
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        // 用中间值创建根节点
        TreeNode newNode = new TreeNode(nums[mid]);
        // 不能再把mid放入边界了，因为mid已经创建了
        // 递归创建左子树
        TreeNode lChild = creatNode(l, mid - 1, nums);
        // 递归创建右子树
        TreeNode rChild = creatNode(mid + 1, r, nums);
        newNode.left = lChild;
        newNode.right = rChild;
        return newNode;
    }
}
