package offer.chapter12;

/**
 * 计数排序
 *
 * @author Mr.黄
 * @date 2022/07/07
 **/
public class CountingSort {
    /**
     * 计数排序模板
     *
     * @param nums 待排序数组
     * @return 排序好的数组
     */
    public int[] sortArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            // 先找出最大值和最小值
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] counts = new int[max - min + 1];
        for (int num : nums) {
            counts[num - min]++;
        }
        int i = 0;
        for (int num = min; num <= max; num++) {
            while (counts[num - min] > 0) {
                nums[i++] = num;
                counts[num - min]--;
            }
        }
        return nums;
    }
}