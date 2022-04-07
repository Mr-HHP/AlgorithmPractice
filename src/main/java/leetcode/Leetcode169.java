package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素
 *
 * @author Mr.黄
 * @date 2022/04/06
 **/
public class Leetcode169 {
    /**
     * 哈希表解法
     *
     * @param nums 给定的数组
     * @return 返回结果
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 1);
            if (count > nums.length / 2) {
                result = num;
                break;
            }
            map.put(num, count + 1);
        }
        return result;
    }
    
    /**
     * 摩尔投票法
     *
     * @param nums 给定的数组
     * @return 返回结果
     */
    public int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
    
    public static void main(String[] args) {
        Leetcode169 leetcode169 = new Leetcode169();
        System.out.println(leetcode169.majorityElement(new int[]{3, 2, 3}));
    }
}