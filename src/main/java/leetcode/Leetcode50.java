package leetcode;

/**
 * Pow(x,n)
 *
 * @author Mr.黄
 * @date 2022/03/26
 **/
public class Leetcode50 {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1.0) {
            return 1;
        }
        double result = 1;
        for (int i = 0; i < Math.abs((long) n); i++) {
            result = result * x;
            if (x > 10000) {
                return 10000;
            }
            if (x < -10000) {
                return -10000;
            }
        }
        return n > 0 ? result : 1 / result;
    }
    
    public static void main(String[] args) {
        Leetcode50 leetcode50 = new Leetcode50();
        double myPow = leetcode50.myPow(2, 10);
        System.out.println(myPow);
    }
}