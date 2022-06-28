package offer.chapter10;

/**
 * 最大的异或
 *
 * 输入一个整数数组（每个数字都大于或等于0），请计算其中任意两个数字的异或的最大值。
 *
 * @author Mr.黄
 * @date 2022/06/28
 **/
public class InterviewQuestion67 {
    public static void main(String[] args) {
        System.out.println((7 >> 1) & 1);
    }
    static class TrieNode {
        public TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[2];
        }
    }
    
    /**
     * 构建数组每个数字二进制的前缀树
     *
     * @param nums 数组
     * @return 数字每个数字二进制格式的前缀树
     */
    private TrieNode buildTrie(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }
        return root;
    }
    
    /**
     * 查找最大的异或数
     *
     * @param nums 给定的数组
     * @return 最大的异或数
     */
    public int findMaximumXOR(int[] nums) {
        TrieNode root = buildTrie(nums);
        // 最终的最大值
        int max = 0;
        for (int num : nums) {
            TrieNode node = root;
            // num与其他整数异或的最大值
            int xor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[1 - bit] != null) {
                    // 从右往左，一位一位的往上顶
                    xor = (xor << 1) + 1;
                    node = node.children[1 - bit];
                } else {
                    // 同上的原理
                    xor = xor << 1;
                    node = node.children[bit];
                }
            }
            max = Math.max(max, xor);
        }
        return max;
    }
}