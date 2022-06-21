package offer.chapter10;

/**
 * 面试题64：神奇的字典
 * 请实现有如下两个操作的神奇字典。
 * 1、函数buildDict，输入单词数组用来创建一个字典。
 * 2、函数search，输入一个单词，判断能否修改该单词中的一个字符，使修改之后的单词是字典中的一个单词。
 *
 * @author Mr.黄
 * @date 2022/06/21
 **/
public class InterviewQuestion64 {
}

class MagicDictionary {
    TrieNode root;
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    public boolean search(String word) {
        return dfs(root, word, 0, 0);
    }
    
    /**
     * 深度优先搜索
     *
     * @param root 根节点
     * @param word 单词
     * @param i 待查找单词的当前字符下标
     * @param edit 编辑次数
     * @return 返回查询结果的布尔值
     */
    private boolean dfs(TrieNode root, String word, int i, int edit) {
        if (root == null) {
            return false;
        }
        if (root.isWord && i == word.length() && edit == 1) {
            return true;
        }
        if (i < word.length() && edit <= 1) {
            boolean found = false;
            for (int j = 0; j < 26 && !found; j++) {
                int next = j == word.charAt(i) - 'a' ? edit : edit + 1;
                found = dfs(root.children[j], word, i + 1, next);
            }
            return found;
        }
        return false;
    }
    
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"cbc"});
        System.out.println(magicDictionary.search("cdc"));
//        System.out.println(magicDictionary.search("cbc"));
        System.out.println('h' - 'a');
    }
    
    /**
     * 构建前缀树字典。
     *
     * @param dict 单词字典
     */
    public void buildDict(String[] dict) {
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
    }
}