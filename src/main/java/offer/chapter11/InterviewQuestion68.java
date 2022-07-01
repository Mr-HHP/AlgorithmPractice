package offer.chapter11;

/**
 * 面试题68：查找插入位置
 *
 * @author Mr.黄
 * @date 2022/07/02
 **/
public class InterviewQuestion68 {
    /**
     * 里用二分法解题
     *
     * @param nums 给定的数组
     * @param target 目标值
     * @return 返回插入的下标
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums.length;
    }
}