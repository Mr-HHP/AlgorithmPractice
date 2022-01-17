package offer.chapter9;

import java.util.PriorityQueue;

/**
 * 面试题59：数据流的第k大的数字
 * <p>
 * 请设计一个类型KthLargest，它每次从一个数据流中读取一个数字，并得出数据流已经读取的数字中第k（k>=1）大的数字。
 * 该类型的构造函数有两个参数：一个是整数k，另一个是包含数据流中最开始数字的整数数组nums（假设数组nums的长度大于k）。
 * 该类型还有一个函数add，用来添加数据流中的新数字并返回数据流中已经读取的数字的第k大的数字。
 *
 * @author Mr.黄
 * @date 2022/01/18
 **/
public class InterviewQuestion59 {

}

/**
 * 利用最小堆实现该数据结构
 *   先找出k个最大的数字，那么第k大的数字就是这k个最大数字中最小的一个。
 *   利用最小堆找到k个数字中最小的一个
 */
class KthLargest {
  /**
   * 最小堆
   */
  private PriorityQueue<Integer> minHeap;
  private int size;
  
  public KthLargest(int k, int[] nums) {
    size = k;
    for (int num : nums) {
      add(num);
    }
  }
  
  /**
   * 函数add，用来添加数据流中的新数字，并返回数据流中已经读取到的数字的第k大数字
   *
   * @param val 待添加的数字
   * @return 已经读取到的数据流中的第k大的数字
   */
  public int add(int val) {
    if (minHeap.size() < size) {
      // 如果最小堆中元素的数目小于k，那么直接添加到最小堆中
      minHeap.offer(val);
    } else if (val > minHeap.peek()) {
      // 最小堆中元素的数目等于k
      // 将新读出来的数字和最小堆最小值比较
      // 如果新读出来的数小于或等于堆中的最小值，那么堆中的k个数字都比它大，因此它不可能是k个最大的数字中的一个。
      // 如果新数字大于堆顶，那么堆顶的数字就是k+1大的数字
      minHeap.poll();
      minHeap.offer(val);
    }
    return minHeap.peek();
  }
  
}
