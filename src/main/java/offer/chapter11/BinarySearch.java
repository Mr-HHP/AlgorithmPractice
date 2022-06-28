package offer.chapter11;

/**
 * 二分查找
 *
 * @author Mr.黄
 * @date 2022/06/28
 **/
public class BinarySearch {
    /**
     * 二分查找模板代码
     *
     * @param nums 升序排序的数组
     * @param target 待查找数字
     * @return 查找结果，查找失败返回-1
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}