package offer.chapter9;

import sun.nio.cs.ext.IBM037;

import java.util.*;

/**
 * 面试题60：出现频率最高的k个数字
 * <p>
 * 请找出数组中出现频率最高的k个数字。
 *
 * @author Mr.黄
 * @date 2022/01/18
 **/
public class InterviewQuestion60 {
  /**
   * 获取给定数组频率最高的k个元素
   *
   * 1、利用哈希表来记录元素和其频率的映射关系
   * 2、利用最小堆来记录k个频率最大的元素
   *
   * 空间复杂度：O(n)
   *   假设数组长度为n，需要O(n)的哈希表、O(k)的堆，所以空间复杂度为O(n)
   * 时间复杂度：O(nlogk)
   *   最小堆的添加、删除为O(logk)；哈希表的遍历为O(n)，所以时间复杂度为O(nlogk)
   *
   * @param nums 给定的数组
   * @param k    k个元素
   * @return 返回数组中频率最高的k个元素集合
   */
  public List<Integer> topKFrequent(int[] nums, int k) {
    // 记录元素和其频率的映射关系
    Map<Integer, Integer> numToCount = new HashMap<>();
    for (int num : nums) {
      // 构建元素与其频率的映射关机
      numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
    }
    // 最小堆（通过构造函数指定的排序方式构建最小堆）
    Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
    for (Map.Entry<Integer, Integer> entry : numToCount.entrySet()) {
      // 遍历映射关系，构建最小堆
      if (minHeap.size() < k) {
        // 最小堆的元素还不足k个
        minHeap.offer(entry);
      } else {
        // 最小堆已经满了
        if (entry.getValue() > minHeap.peek().getValue()) {
          // 当前元素大于最小堆的堆顶元素
          // 说明当前元素包含在k个元素里
          minHeap.poll();
          minHeap.offer(entry);
        }
      }
    }
    // 遍历最小堆获取结果
    List<Integer> result = new LinkedList<>();
    for (Map.Entry<Integer, Integer> entry : minHeap) {
      result.add(entry.getKey());
    }
    return result;
  }
}