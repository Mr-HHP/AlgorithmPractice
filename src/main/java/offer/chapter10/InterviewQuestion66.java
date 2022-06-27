package offer.chapter10;

/**
 * 单词之和
 * <p>
 * 设计实现一个类型MapSum，他有如下两个操作。
 * 1、函数insert，输入一个字符串和一个整数，在数据集合中添加一个字符串及其对应的值。如果数据集合中已经包含该字符串，则将该字符串对应的值替换成新值
 * 2、函数sum，输入一个字符串，返回数据集合中所有以该字符串为前缀的字符串对应的值之和
 *
 * @author Mr.黄
 * @date 2022/06/27
 **/
public class InterviewQuestion66 {
}

class MapSum {
    static class TrieNode {
        public TrieNode[] children;
        public int value;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    private TrieNode root;
    
    public MapSum() {
        root = new TrieNode();
    }
    
    /**
     * insert函数
     *
     * @param key 给定的字符串
     * @param val 对应的值
     */
    public void insert(String key, int val) {
        TrieNode node = root;
        for (int i = 0; i < key.length(); ++i) {
            char ch = key.charAt(i);
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.value = val;
    }
    
    /**
     * sum函数
     *
     * @param prefix 字符串前缀
     * @return 以prefix为前缀的字符串对应的值的累计的值
     */
    public int sum(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); ++i) {
            char ch = prefix.charAt(i);
            if (node.children[ch - 'a'] == null) {
                return 0;
            }
            node = node.children[ch - 'a'];
        }
        return getSum(node);
    }
    
    private int getSum(TrieNode node) {
        if (node == null) {
            return 0;
        }
        int result = node.value;
        for (TrieNode child : node.children) {
            result += getSum(child);
        }
        return result;
    }
}