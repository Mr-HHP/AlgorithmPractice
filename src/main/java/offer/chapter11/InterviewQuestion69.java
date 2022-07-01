package offer.chapter11;

/**
 * 面试题69：山峰数组的顶部
 *
 * @author Mr.黄
 * @date 2022/07/02
 **/
public class InterviewQuestion69 {
    /**
     * 利用二分法解题
     *
     * @param nums 给定的山峰数组
     * @return 最大值的下标
     */
    public int peakIndexInMountainArray(int[] nums) {
        int left = 0;
        // 由于第一个和最后一个都不可能是最大值，所以减2
        int right = nums.length - 2;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            }
            if (nums[mid] > nums[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}