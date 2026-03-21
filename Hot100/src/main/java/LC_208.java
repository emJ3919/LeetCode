import java.util.Arrays;

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
