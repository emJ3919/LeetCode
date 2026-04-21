/**
 * 题目：相交链表
 * 思路：方法1（推荐）用双指针消除长度差。
 * 两指针pa、pb分别从A、B头节点出发，走完后换到另一链表继续走。
 * 相当于 pa走：A长度 + B长度，pb走：B长度 + A长度，一定相遇。
 * 有交点 → 在交点相遇；无交点 → 在null处相遇。
 * 方法2：暴力枚举，对A每个节点遍历B，时间复杂度O(mn)。
 * 时间复杂度：O(m+n)，空间复杂度：O(1)
 */
public class LC_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){ // 需要构造相交链表函数
        if (headA == null || headB == null){
            return null;
        }
        // 两个指针pa和pb，分别从头节点headA和headB开始遍历链表
        ListNode pa = headA;
        ListNode pb = headB;
        // 遍历链表，直到pa和pb相遇
        while (pa != pb){
            // 如果pa遍历到链表A的末尾，让pa去走链表B
            if(pa == null){
                pa = headB;
            }else { // 如果pa没有遍历到链表A的末尾，继续遍历
                pa = pa.next;
            }
            // 如果pb遍历到链表B的末尾，让pb去走链表A
            if (pb == null){
                pb = headA;
            }else { // 如果pb没有遍历到链表B的末尾，继续遍历
                pb = pb.next;
            }
        }
        return pa;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        if (headA == null || headB == null){
            return null;
        }
        while ( headA != null){
            ListNode tmpNode = headB;
            while (tmpNode != null){
                if (tmpNode == headA){
                    return tmpNode;
                }
                tmpNode = tmpNode.next;
            }
            headA = headA.next;
        }
        return null;
    }
}
