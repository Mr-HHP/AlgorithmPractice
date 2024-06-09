package leetcode2;

import java.util.*;

/**
 * @author Mr.黄
 * @description 滑动窗口最大值
 * @since 2024/6/8 15:18
 **/
public class LeetCode239 {
    public static void main(String[] args) {
        LeetCode239 leetCode239 = new LeetCode239();
        leetCode239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
    // [1,3,-1,-3,5,3,6,7]
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] != o1[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        for (int i = 0; i < k; i++) {
            pq.add(new int[]{nums[i], i});
        }
        int[] result = new int[nums.length - k + 1];
        result[0] = pq.peek()[0];
        for (int i = k; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            result[i - k + 1] = pq.peek()[0];
        }
        return result;
    }
}
