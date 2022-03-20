package leetcode;

/**
 * 删除有序数组中的重复项
 *
 * @author Mr.黄
 * @date 2022/03/21
 **/
public class Leetcode26 {
    /**
     * 常规的两层迭代解题
     *
     * @param nums 给定的数组
     * @return 返回的结果数组
     */
    public int removeDuplicates(int[] nums) {
        int jump = 0;
        int length = 1;
        for (int i = 0; i < nums.length - 1 && jump < nums.length; i++) {
            for (int j = jump + 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    nums[i + 1] = nums[j];
                    jump = j;
                    length++;
                    break;
                }
            }
        }
        return length;
    }
    
    /**
     * 双指针法解题
     *
     * @param nums 给定的数组
     * @return 返回结果数组
     */
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                if (q - p > 1) {
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }
}