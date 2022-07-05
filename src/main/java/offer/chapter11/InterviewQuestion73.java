package offer.chapter11;

/**
 * 面试题73：狒狒吃香蕉
 *
 * @author Mr.黄
 * @date 2022/07/05
 **/
public class InterviewQuestion73 {
    public int minEatingSpeed(int[] piles, int H) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            // 找出最大的一堆香蕉数目
            max = Math.max(max, pile);
        }
        int left = 1;
        int right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hours = getHors(piles, mid);
            if (hours <= H) {
                if (mid == 1 || getHors(piles, mid - 1) > H) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
    /**
     * 计算按某一速度吃完所有香蕉所需要的时间
     *
     * @param piles 香蕉堆数
     * @param speed 吃香蕉的速度
     * @return 所需时间
     */
    private int getHors(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
        }
        return hours;
    }
}