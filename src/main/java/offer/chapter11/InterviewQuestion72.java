package offer.chapter11;

/**
 * 面试题72：求平方根
 *
 * @author Mr.黄
 * @date 2022/07/05
 **/
public class InterviewQuestion72 {
    /**
     * 利用二分法解题
     *
     * @param n 非负整数
     * @return n的平方根，如果平方根不为整数，则只返回整数部分
     */
    public int mySqrt(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= n / mid) {
                // mid * mid <= n 等价于 mid <= n / mid，因为前者会有溢出的风险，所以用后者替换
                if ((mid + 1) > n / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // n=0的情况
        return 0;
    }
    
}