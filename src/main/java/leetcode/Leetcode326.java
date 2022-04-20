package leetcode;

/**
 * 3的幂
 *
 * @author Mr.黄
 * @date 2022/04/20
 **/
public class Leetcode326 {
    /**
     * 利用循环解题
     *
     * @param n 给定的数字
     * @return 是否是3的幂次方
     */
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            System.out.println("n: " + n);
            n /= 3;
        }
        return n == 1;
    }
    
    /**
     * 利用倍数&约数解题
     *
     * @param n 给定的数字
     * @return 是否是3的幂次方
     */
    public boolean isPowerOfTree2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Leetcode326().isPowerOfThree(6));
        System.out.println(new Leetcode326().isPowerOfThree(9));
    }
}