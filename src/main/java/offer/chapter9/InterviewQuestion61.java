package offer.chapter9;

import java.util.*;

/**
 * 面试题61：和最小的k个数对
 * <p>
 * 给定两个递增排序的整数数组，从两个数组中各取一个数字u和v组成一个数对（u，v）
 * 请找出和最小的k个数对。
 *
 * @author Mr.黄
 * @date 2022/01/20
 **/
public class InterviewQuestion61 {
  /**
   * 获取和最小的k个数对
   *
   * 利用最大堆解题
   * 如果堆长度不大于k，将数对和放入最大堆中
   *   1、当前元素小于堆顶元素，删除堆顶元素，当前元素入堆，此时的堆的所有元素就是k个最小的元素
   *   2、当前元素大于堆顶元素，不管
   *
   * 时间复杂度：O(k2logk)
   *   两个for循环时间复杂度为：O(k2)
   *   堆的删除、添加操作时间复杂度：O(logk)
   *   while循环的时间复杂度：O(klogk)
   * 所以，总的时间复杂度是O(k2logk)
   *
   * @param nums1 给定的递增排序的整数数组nums1
   * @param nums2 给定的递增排序的整数数组nums2
   * @param k     数量
   * @return 返回和最小的k个数对
   */
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    // 最大堆，每个元素都是一个长度为2的数组，表示一个数对
    // 因为要创建最大堆，所以要自定义排序
    Queue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> p2[0] + p2[1] - p1[0] - p1[1]);
    for (int i = 0; i < Math.min(k, nums1.length); i++) {
      for (int j = 0; j < Math.min(k, nums2.length); j++) {
        // 双重循环获取两个整数数组前k个元素的所有数对
        if (maxHeap.size() >= k) {
          // 堆已满
          int[] root = maxHeap.peek();
          if (root[0] + root[1] > nums1[0] + nums1[1]) {
            // 当前数对之和小于堆顶数对之和
            // 进行与堆顶元素进行替换
            maxHeap.poll();
            maxHeap.offer(new int[]{nums1[0], nums1[1]});
          }
        } else {
          // 堆未满，直接入堆
          maxHeap.offer(new int[]{nums1[i], nums1[j]});
        }
      }
    }
    List<List<Integer>> result = new LinkedList<>();
    while (!maxHeap.isEmpty()) {
      int[] vals = maxHeap.poll();
      result.add(Arrays.asList(vals[0], vals[1]));
    }
    return result;
  }
}