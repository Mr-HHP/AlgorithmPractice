package offer.chapter12;

/**
 * 面试题75：数组相对排序
 *
 * @author Mr.黄
 * @date 2022/07/10
 **/
public class InterviewQuestion75 {
    /**
     * 使用计数排序解题
     *
     * @param arr1 数组arr1
     * @param arr2 数组arr2
     * @return 排序后的数组arr1
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 计数排序辅助数组
        int[] counts = new int[1001];
        for (int num : arr1) {
            counts[num]++;
        }
        int i = 0;
        for (int num : arr2) {
            while (counts[num] > 0) {
                // 在现有的数组上直接进行排序，节省内存空间
                arr1[i++] = num;
                counts[num]--;
            }
        }
        for (int num = 0; num < counts.length; num++) {
            // 最后对arr2中不存在的数字进行排序
            while (counts[num] > 0) {
                arr1[i++] = num;
                counts[num]--;
            }
        }
        return arr1;
    }
}