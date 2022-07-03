package offer.chapter11;

import java.util.Random;

/**
 * 按权重生成随机数
 *
 * @author Mr.黄
 * @date 2022/07/03
 **/
public class InterviewQuestion71 {
    /**
     * P(0)=10%  0<1
     * P(1,2)=20%  (1,2)<3
     * P(3,4,5)=30%  (3,4,5)<6
     * P(6,7,8,9)=40%  (6,7,8,9)<10
     */
    class Solution {
        // 辅助数组，和权重数组长度一样。
        private int[] sums;
        private int total;
        
        public Solution(int[] w) {
            sums = new int[w.length];
            for (int i = 0; i < w.length; ++i) {
                total += w[i];
                sums[i] = total;
            }
        }
        
        public int pickIndex() {
            Random random = new Random();
            int p = random.nextInt(total);
            int left = 0;
            int right = sums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (sums[mid] > p) {
                    if (mid == 0 || (sums[mid - 1] <= p)) {
                        return mid;
                    }
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
}