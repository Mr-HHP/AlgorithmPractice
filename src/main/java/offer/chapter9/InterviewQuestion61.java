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
   * <p>
   * 利用最大堆解题
   * 如果堆长度不大于k，将数对和放入最大堆中
   * 1、当前元素小于堆顶元素，删除堆顶元素，当前元素入堆，此时的堆的所有元素就是k个最小的元素
   * 2、当前元素大于堆顶元素，不管
   * <p>
   * 时间复杂度：O(k2logk)
   * 两个for循环时间复杂度为：O(k2)
   * 堆的删除、添加操作时间复杂度：O(logk)
   * while循环的时间复杂度：O(klogk)
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
    // 每个数对的第1个数字来自数组nums1，第2个数字来自数组nums2
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
  
  /**
   * 利用最小堆解题
   *   最小堆是一个辅助结构，里面存储的是所有候选数对
   *
   *   如果和最小的数对的两个数字在两个数组中的下标分别为i1和i2，
   *   将该数对添加到结果中并将其从最小堆中删除，
   *   再将在两个数组中下标分别为i1和i2+1的两个数字作为新的候选数对添加到最小堆
   *
   * 时间复杂度：O(klogk)
   *   for循环执行k次，构建一个大小为k的最小堆，时间复杂度为O(klogk)
   *   while循环执行k次，每次对大小为k的最小堆进行添加或删除操作，时间复杂度为O(klogk)
   *   所以总时间复杂度为O(klogk)
   *
   * @param nums1 给定的递增排序的整数数组nums1
   * @param nums2 给定的递增排序的整数数组nums2
   * @param k     数量
   * @return 返回和最小的k个数对
   */
  public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
    // 最小堆，每个元素是一个长度为2的数组
    // 数组第1个数字表示数对的第1个数字在数组nums1中的下标，第2个数字表述数对的弟2个数字在数组nums2中的下标
    // 因为是最小堆，所以是正序排序
    Queue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> nums1[p1[0]] + nums2[p1[1]] - nums1[p2[0]] - nums2[p2[1]]);
    if (nums2.length > 0) {
      for (int i = 0; i < Math.min(k, nums1.length); i++) {
        // 第2个数组固定在下标0处，以此将nums1的下标挪动，将候选数对保存到最小堆
        // (0, 0),(1, 0),(2, 0)...(k, 0)
        minHeap.offer(new int[]{i, 0});
      }
    }
    List<List<Integer>> result = new ArrayList<>();
    while (k-- > 0 && !minHeap.isEmpty()) {
      // 从最小堆中去除最小值
      int[] ids = minHeap.poll();
      // 和最小的数对保存
      result.add(Arrays.asList(nums1[ids[0]], nums2[ids[1]]));
      if (ids[1] < nums2.length - 1) {
        // 添加新的候选数对
        minHeap.offer(new int[]{ids[0], ids[1] + 1});
      }
    }
    return result;
  }
  
  public static void main(String[] args) {
    InterviewQuestion61 interviewQuestion61 = new InterviewQuestion61();
    int[] nums1 = new int[]{1, 5, 13, 21};
    int[] nums2 = new int[]{2, 4, 9, 15};
    List<List<Integer>> lists = interviewQuestion61.kSmallestPairs2(nums1, nums2, 3);
    System.out.println("\n\n");
    for (List<Integer> list : lists) {
      for (int i : list) {
//        System.out.println(i);
      }
//      System.out.println("$$$$$$$$$$$$$$$");
    }
  }
  
}