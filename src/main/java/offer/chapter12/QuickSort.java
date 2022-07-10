package offer.chapter12;

import java.util.Random;

/**
 * 快速排序
 *
 * @author Mr.黄
 * @date 2022/07/10
 **/
public class QuickSort {
    /**
     * 在输入数组中随机选择一个元素作为中间值（pivot），然后对数组进行分区（partition），
     * 使所有比中间值小的数据移到数组左边，所有比中间值大的数据移到数组的右边。
     * 接下来对中间值左右两侧的子数组用相同的步骤排序，知道子数组中只有一个数字为止。
     * 这个过程可以用递归实现
     *
     * @param nums 待排序数组
     * @return 排序好的数组
     */
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    /**
     * 递归进行排序
     *
     * @param nums  待排序数组
     * @param start 开始位置
     * @param end   结束位置
     */
    public void quickSort(int[] nums, int start, int end) {
        if (end > start) {
            // 根据中间值进行分区
            int pivot = partition(nums, start, end);
            // 对左边排序
            quickSort(nums, start, pivot - 1);
            // 对右边排序
            quickSort(nums, pivot + 1, end);
        }
    }
    
    /**
     * 根据中间值进行分区操作
     *
     * @param nums  待分区数组
     * @param start 开始位置
     * @param end   结束位置
     * @return 中间值的最终下标
     */
    private int partition(int[] nums, int start, int end) {
        int random = new Random().nextInt(end - start + 1) + start;
        // 将选出的随机值交换到数组最后的位置
        swap(nums, random, end);
        int small = start - 1;
        // 进行分区操作
        for (int i = start; i < end; i++) {
            // 指针P1向前移动一位
            small++;
            // 交换指针P1和P2位置的数字
            swap(nums, i, small);
        }
        // 最后再交换中间值的位置
        small++;
        swap(nums, small, end);
        return small;
    }
    
    /**
     * 进行位置交换
     *
     * @param nums   待交换的数组
     * @param index1 位置1
     * @param index2 位置2
     */
    private void swap(int[] nums, int index1, int index2) {
        if (index1 != index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }
}