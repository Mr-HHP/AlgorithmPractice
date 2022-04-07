package leetcode;

/**
 * Excel表格序号
 *
 * @author Mr.黄
 * @date 2022/04/06
 **/
public class Leetcode171 {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        char[] chars = columnTitle.toCharArray();
        double rank = chars.length - 1;
        for (int i = 0; i < chars.length; i++) {
            result += (chars[i] - 'A' + 1) * Math.pow(26d, rank);
            rank--;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Leetcode171 leetcode171 = new Leetcode171();
        System.out.println((int) 'A');
        System.out.println(leetcode171.titleToNumber("A"));
    }
}