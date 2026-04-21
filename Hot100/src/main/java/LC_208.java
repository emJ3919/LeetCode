import java.util.Arrays;

/**
 * 题目：实现 Trie (前缀树)
 * 思路：前缀树。26叉树
 * 每个节点包含26个字母index的数组和一个结束标志。
 * insert：逐字符向下遍历，不存在则创建节点，遍历完设置结束标志。
 * search：从根节点逐字符向下遍历，若某路径不存在则返回false，遍历完判断是否是结束标志。
 * startsWith：与search类似，只需判断路径是否存在，无需判断结束标志。
 * 时间复杂度：insert/search/startsWith均为O(n)，n为字符串长度。空间复杂度：O(V)，V为节点数。
 */
public class LC_208 {
    class Trie{
        // 每层存26个字母
        private Trie[] children;
        // 是否结束
        private boolean isEnd;
        public Trie(){
            this.children = new Trie[26];
            this.isEnd = false;
        }

        public void insert(String word){
            // node 相当于一个探路者，初始位置在起点（根节点/this）
            Trie node = this;
            for (int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                // 用下标代替字符
                int index = ch - 'a';
                // 如果这个节点不存在就创建
                if (node.children[index] == null){
                    Trie child = new Trie();
                    node.children[index] = child;
                }
                // 继续向下探索
                node = node.children[index];
            }
            // 遍历完后设置该位置结束
            node.isEnd = true;
        }

        public boolean search(String word){
            Trie node = this;
            // 向下探索
            for (int i = 0; i < word.length(); i++){
                int index = word.charAt(i) - 'a';
                // 如果中间某个路径都没创建说明一定没记录
                if (node.children[index] == null) return false;
                node = node.children[index];
            }
            // 判断该字符串是否是结尾
            return node.isEnd;
        }

        public boolean startsWith(String prefix){
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++){
                int index = prefix.charAt(i) - 'a';
                // 如果中间某个路径都没创建说明一定没记录
                if (node.children[index] == null) return false;
                node = node.children[index];
            }
            return true;
        }
    }
}
