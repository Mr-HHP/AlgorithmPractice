package offer.chapter10;

import java.util.List;

/**
 * 面试题63：替换单词
 *
 * @author Mr.黄
 * @date 2022/06/20
 **/
public class InterviewQuestion63 {
    /**
     * 利用前缀树解体
     *
     * @param dict 前缀字典
     * @param sentence 句子
     * @return 替换后的句子
     */
    public String replaceWords(List<String> dict, String sentence) {
        // 构建前缀树字典
        TrieNode root = buildTrie(dict);
        StringBuilder builder = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            // 查找前缀字典里是否有改单词的前缀
            String prefix = findPrefix(root, words[0]);
            if (!prefix.isEmpty()) {
                words[i] = prefix;
            }
        }
        return String.join(" ", words);
    }
    
    /**
     * 构建前缀树
     *
     * @param dict 词根字典
     * @return 词根前缀树
     */
    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode();
        for (String word : dict) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }
        return root;
    }
    
    /**
     * 查找单词前缀
     * @param root 前缀树根节点
     * @param word 单词
     * @return 返回单词的前缀。如果没有前缀则返回空字符串
     */
    private String findPrefix(TrieNode root, String word) {
        TrieNode node = root;
        StringBuilder builder = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (node.isWord || node.children[ch - 'a'] == null) {
                break;
            }
            builder.append(ch);
            node = node.children[ch - 'a'];
        }
        return node.isWord ? builder.toString() : "";
    }
}