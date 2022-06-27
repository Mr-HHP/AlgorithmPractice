package offer.chapter10;

/**
 * 最短的单词编码
 *
 * 利用前缀树解题
 *
 * @author Mr.黄
 * @date 2022/06/27
 **/
public class InterviewQuestion65 {
    static class TrieNode {
        public TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = buildTrie(words);
        int total[] = {0};
        dfs(root, 1, total);
        return total[0];
    }
    
    /**
     * 反转单词进行构建前缀树
     *
     * @param words 给定的单词数组
     * @return 构建好的前缀树
     */
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
        }
        return root;
    }
    
    /**
     * 树的深度优先遍历
     *
     * @param root 数的节点
     * @param length 当前累计非叶子节点数
     * @param total 编码后的最短字符串
     */
    private void dfs(TrieNode root, int length, int[] total) {
        boolean isLeaf = true;
        for (TrieNode child : root.children) {
            if (child != null) {
                isLeaf = false;
                dfs(child, length + 1, total);
            }
        }
        if (isLeaf) {
            total[0] += length;
        }
    }
}