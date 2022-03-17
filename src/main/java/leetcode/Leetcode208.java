package leetcode;

/**
 * 前缀树
 *
 * @author Mr.黄
 * @date 2022/03/18
 **/
public class Leetcode208 {
    static class TrieNode {
        TrieNode[] children;
        boolean isWord;
        
        public TrieNode() {
            // 每个节点可能对应26个小写英文字母的任意一个
            children = new TrieNode[26];
        }
    }
    private TrieNode root;
    
    public Leetcode208() {
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