package leetcode;

/**
 * 外观数列
 *
 * @author Mr.黄
 * @date 2022/05/01
 **/
public class Leetcode38 {
    /**
     * 遍历生成
     *
     * @param n 给定的第n项
     * @return 外观数列的第n项
     */
    public String countAndSay(int n) {
        // 起始结果
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            // 开始字符
            int start = 0;
            // 查找位置
            int pos = 0;
            while (pos < str.length()) {
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    // 查找位置符合长度内，并且查找字符等于开始字符
                    pos++;
                }
                sb.append(Integer.toString(pos - start)).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }
        return str;
    }
}