/**
 * 题目：随机链表的复制
 * 思路：三步法。
 * 第一步：遍历原链表，在每个节点后插入复制的节点，形成 A->a->B->b 交替结构。
 * 第二步：复制random指针，由于复制节点在原节点的下一个，原节点.random的下一个即为复制节点的random。
 * 第三步：分离两个链表，恢复原链表并提取复制链表。
 * 时间复杂度：O(n)，空间复杂度：O(1)。
 */
public class LC_138 {
    // 随机指针的链表
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val){
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head){
        if (head == null) return null;
        Node cur = head;
        // 遍历复制结点接在原节点后面: A->a->B->b->C->c.....（a,b,c...是复制节点）
        while (cur != null){
            Node copy_node = new Node(cur.val);
            copy_node.next = cur.next;
            cur.next = copy_node;
            cur = copy_node.next;
        }
        // 复制random指针
        cur = head;
        while (cur != null){
            if(cur.random != null){
                // 指向的复制节点在原节点的下一个
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        // 复制节点的头节点
        Node ans = head.next;
        Node ans_cur = head.next;
        // 将复制节点拆出来
        while (ans_cur != null){
            // 原链表
            cur.next = ans_cur.next;
            cur = cur.next;
            // 原链表走到头了
            if(cur == null){
                break;
            }
            ans_cur.next = cur.next;
            ans_cur = ans_cur.next;
        }
        return ans;
    }
}
