public class LC_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int l = 0;
        int r = nums.length - 1;
        return creatNode(l, r, nums);
    }

    private TreeNode creatNode(int l, int r, int[] nums){
        // 不需要创建节点
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode newNode = new TreeNode(nums[mid]);
        // 不能再把mid放入边界了，因为mid已经创建了
        TreeNode lChild = creatNode(l, mid - 1, nums);
        TreeNode rChild = creatNode(mid + 1, r, nums);
        newNode.left = lChild;
        newNode.right = rChild;
        return newNode;
    }
}
