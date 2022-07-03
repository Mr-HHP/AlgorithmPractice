package offer.chapter11;

/**
 * 面试题70：排序数组中只出现一次的数字
 *
 * @author Mr.黄
 * @date 2022/07/03
 **/
public class InterviewQuestion70 {
    /**
     * 利用二分法解题
     *
     * @param nums 给定的排序数组
     * @return 只出现一次的数字
     */
    public int singleNonDuplicate(int[] nums) {
        // 查找范围内第1个分组的编号
        int left = 0;
        // 查找范围内最后一个分组的编号
        int right = nums.length / 2;
        while (left <= right) {
            // 查找范围中间编号位mid的分组
            int mid = (left + right) / 2;
            // 这个分组的第1个数字在数组中的下标
            int i = mid * 2;
            if (i < nums.length - 1 && nums[i] != nums[i + 1]) {
                if (mid == 0 || nums[i - 2] == nums[i - 1]) {
                    return nums[i];
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 边界情况，只出现一次的数字在数组尾部
        return nums[nums.length - 1];
    }
}