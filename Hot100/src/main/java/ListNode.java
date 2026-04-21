public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }

    // 生成链表
    public ListNode generateLinkList(int[] nums){
        if (nums == null || nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        // 从第二个元素开始遍历，将每个元素连接到当前节点的next
        for (int i = 1; i < nums.length; i++){
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    // 生成相交链表
    /**
     * 输入：nums1, nums2, intersectVal, skipA, skipB
     * 分别表示链表1、链表2、相交节点的值、链表1中跳过节点数、链表2中跳过节点数。
     */
    public ListNode[] generateIntersectLinkList(int[] nums1, int[] nums2, int intersectVal, int skipA, int skipB){
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return null;
        ListNode head1 = generateLinkList(nums1); // 生成链表函数
        ListNode head2 = generateLinkList(nums2);
        // 找到相交节点
        ListNode intersectNode = head1;
        for (int i = 0; i < skipA; i++){
            intersectNode = intersectNode.next;
        }
        // 找到链表2的交点前一个节点，如果skipB为0,则交点为头节点
        if (skipB == 0) head2 = intersectNode;
        else {
            ListNode cur2 = head2;
            for (int i = 0; i < skipB - 1; i++){
                cur2 = cur2.next;
            }
            // 让交点前一个节点的 next 指向真正的交点，后面的直接抛弃
            cur2.next = intersectNode;
        }
        return new ListNode[]{head1, head2};
    }

    // 生成环形链表
    /**
     * 输入：nums, pos
     * 分别表示链表的节点值和环的起始位置。
     */
    public ListNode generateCycleLinkList(int[] nums, int pos){
        if (nums == null || nums.length == 0) return null;
        ListNode head = generateLinkList(nums);
        // 找到环的起始节点
        ListNode cycleNode = head;
        for (int i = 0; i < pos; i++){
            cycleNode = cycleNode.next;
        }
        // 让最后一个节点指向环的起始节点
        ListNode cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = cycleNode;
        return head;
    }
}
