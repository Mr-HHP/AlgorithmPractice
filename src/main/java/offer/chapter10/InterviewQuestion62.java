package offer.chapter10;

/**
 * 面试题62：实现前缀树
 * 请设计实现一棵前缀树Trie，它有如下操作。
 * 函数insert，在前缀树中添加一个字符串。
 * 函数search，查找字符串。如果前缀树中包含该字符串，则返回true，否则返回false。
 * 函数startWith，查找字符串前缀。如果前缀树中包含以该前缀开头的字符串，则返回true，否则返回false。
 *
 * @author Mr.黄
 * @date 2022/01/24
 **/
public class InterviewQuestion62 {
    public static void main(String[] args) {
        
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;
    
    public TrieNode() {
        // 第一个元素对应字母‘a’的子节点；第二个元素对应字母‘b’的子节点，以此类推
        children = new TrieNode[26];
    }
}

class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    /**
     * 在前缀树中添加一个字符串
     *
     * @param word 字符串
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isWord = true;
    }
    
    /**
     * 查找字符串。如果前缀树中包含该字符串，则返回true，否则返回false。
     *
     * @param word 给定字符串
     * @return 包含返回true，否则返回false
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return node.isWord;
    }
    
    /**
     * 查找字符串前缀。如果前缀树中包含以该前缀开头的字符串，则返回true，否则返回false。
     *
     * @param prefix 字符串前缀
     * @return 以该前缀开头返回true，否则返回false
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return true;
    }
}