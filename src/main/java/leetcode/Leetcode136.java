package leetcode;

/**
 * 只出现一次的数字
 *
 * @author Mr.黄
 * @date 2022/03/24
 **/
public class Leetcode136 {
    /**
     * 利用异或解题，任何数字异或它自己结果都是0
     *
     * @param nums 给定的整数数组
     * @return 只出现一次的数字
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}