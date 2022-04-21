package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两个数组的交集2
 *
 * @author Mr.黄
 * @date 2022/04/21
 **/
public class Leetcode350 {
    /**
     * 哈希表解题
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 结果数组
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                map.put(num, count);
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}