public class LC_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
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

    public ListNode solution2(ListNode headA, ListNode headB){
        if (headA == null || headB == null){
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb){
            if(pa == null){
                pa = headB;
            }else {
                pa = pa.next;
            }
            if (pb == null){
                pb = headA;
            }else {
                pb = pb.next;
            }
        }
        return pa;
    }

    public static void main(String[] args){

    }
}
