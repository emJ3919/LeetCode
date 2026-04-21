import java.util.HashMap;
import java.util.Map;

/**
 * 题目：LRU 缓存
 * 思路：哈希表 + 双向链表。
 * 哈希表支持O(1)查找，双向链表维护访问顺序。
 * 每次访问或插入数据，将节点移到链表头部（最新使用）。
 * 容量满时，删除链表尾部节点（最久未使用）。
 * 时间复杂度：O(1)，空间复杂度：O(capacity)。
 */
public class LC_146 {
    public class LRUCache{
        // k-v，双向链表存储
        private class Node{
            int key, value;
            Node prev, next;
            public Node(){}
            public Node(int key, int value){
                this.key = key;
                this.value = value;
                this.next = null;
                this.prev = null;
            }
        }
        // 容量
        int capacity, length;
        // 头尾节点
        Node head, tail;
        // 哈希表，支持O（1）查询
        Map<Integer, Node> map;

        // 构造函数
        public LRUCache(int capacity){
            this.capacity = capacity;
            this.head = new Node();
            this.tail = new Node();
            this.length = 0;
            this.map = new HashMap<>();
            // 头尾指针相连
            head.next = tail;
            tail.prev = head;
        }

        public void put(int key, int value){
            // 当前操作的节点
            Node tmpNode;
            // 存过这个key，更新value，取出这个节点，后面要重新插入头节点后
            if(map.containsKey(key)){
                tmpNode = map.get(key);
                tmpNode.value = value;
                // 断开当前节点的前后
                tmpNode.prev.next = tmpNode.next;
                tmpNode.next.prev = tmpNode.prev;
            }
            // 容量满了，且没存过这个key：删除最后一个，创建新的node
            else if(capacity == length && !map.containsKey(key)){
                Node delNode = tail.prev;
                tail.prev = delNode.prev;
                delNode.prev.next = tail;
                delNode.next = null;
                delNode.prev = null;
                tmpNode = new Node(key,value);
                // 删除哈希表相关数据
                map.remove(delNode.key);
            }
            // 容量没满，追加
            else {
                tmpNode = new Node(key, value);
                length++;
            }
            // 插入头节点后
            head.next.prev = tmpNode;
            tmpNode.next = head.next;
            tmpNode.prev = head;
            head.next = tmpNode;
            // 放入哈希表
            map.put(key, tmpNode);
        }

        public int get(int key){
            if (map.containsKey(key)){
                Node tmpNode = map.get(key);
                // 断开
                tmpNode.prev.next = tmpNode.next;
                tmpNode.next.prev = tmpNode.prev;
                head.next.prev = tmpNode;
                // 插入头节点后
                tmpNode.next = head.next;
                tmpNode.prev = head;
                head.next = tmpNode;
                return tmpNode.value;
            }else {
                return -1;
            }
        }
    }
}
