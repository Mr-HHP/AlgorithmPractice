package offer.chapter8;

import sun.rmi.runtime.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 面试题57：值和下标之差都在给定的范围内
 * <p>
 * 给定一个整数数组nums和两个正数k、t，请判断是否存在两个不同的下标i和j满足i和j之差的绝对值不大于给定的k，
 * 并且两个数值nums[i]和nums[j]的差的绝对值不大于给定的t。
 *
 * @author Mr.黄
 * @date 2022/01/09
 **/
public class InterviewQuestion57 {
  /**
   * 时间复杂度为O(nlogk)的解法
   *   1、遍历数组找到小于或等于nums[i]的最大的数字j，如果nums[i] - j <= t，则返回true
   *   2、遍历数组找到大于或等于nums[i]的最小的数字j，如果j - nums[i] <= t，则返回true
   *
   * set是一个TreeSet，大小为k，因此
   *   空间复杂度为：O(k)
   * 对TreeSet做查找、添加和删除操作的时间复杂度都是O(logk)，因此
   *   时间复杂度为：O(nlogk)
   *
   * @param nums 给定的整数数组
   * @param k 给定的正数k
   * @param t 给定的正数t
   * @return 符合要求则返回true，否则返回false
   */
  public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
    TreeSet<Long> set = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      // 找到小于或等于nums[i]的最大的数字j
      Long lower = set.floor((long) nums[i]);
      if (lower != null && lower >= (long) nums[i] - t) {
        // nums[i] - j <= t
        return true;
      }
      // 找到大于或等于nums[i]的最小的数字j
      Long upper = set.ceiling((long) nums[i]);
      if (upper != null && upper <= (long) nums[i] + t) {
        // j - nums[i] <= t
        return true;
      }
      set.add((long) nums[i]);
      if (i >= k) {
        // 当前长度超过了k，删除最后一个数字，保证长度在k以内
        set.remove((long) nums[i - k]);
      }
    }
    return false;
  }
  
  /**
   * 时间复杂度为O(n)的解法
   *
   * @param nums 给定的数组
   * @param k 给定的正数k
   * @param t 给定的正数t
   * @return 符合条件返回true，否则返回false
   */
  public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
    Map<Integer, Integer> buckets = new HashMap<>();
    int bucketSize = t + 1;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      int id = getBucketId(num, bucketSize);
      if (buckets.containsKey(num)
        || (buckets.containsKey(id - 1) && buckets.get(id - 1) + t >= num)
        || (buckets.containsKey(id + 1) && buckets.get(id + 1) - t <= num)) {
        // 1、当前桶已经存在数字，那么就找到了两个差的绝对值小于或等于t的数字
        // 2、桶中没有数字，往前一个桶寻找是否存在满足条件的数字
        // 3、桶中没有数据，往后一个桶寻找是否存在满足条件的数字
        return true;
      }
      buckets.put(id, num);
      if (i >= k) {
        // 当前长度超过了k，删除最后一个数字，保证长度在k以内
        buckets.remove(getBucketId(nums[i - k], bucketSize));
      }
    }
    return false;
  }
  
  /**
   * 获取数字对应的桶编号
   *
   * @param num 给定的数字
   * @param bucketSize 桶的大小
   * @return 返回给定数字对应的桶编号
   */
  private int getBucketId(int num, int bucketSize) {
    return num >= 0 ? num / bucketSize : (num + 1) / bucketSize - 1;
  }
  
}