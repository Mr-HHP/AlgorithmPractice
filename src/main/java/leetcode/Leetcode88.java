package leetcode;

import java.util.Arrays;

/**
 * 合并两个有序数组
 *
 * @author Mr.黄
 * @date 2022/03/22
 **/
public class Leetcode88 {
    /**
     * 先合并后排序
     *
     * @param nums1 数组1
     * @param m     数组1的元素个数
     * @param nums2 数组2
     * @param n     数组2的袁术个数
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
    
    /**
     * 双指针法
     *
     * @param nums1 数组1
     * @param m     数组1的元素个数
     * @param nums2 数组2
     * @param n     数组2的袁术个数
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }
    
    /**
     * 逆向双指针
     *
     * @param nums1 数组1
     * @param m     数组1的元素个数
     * @param nums2 数组2
     * @param n     数组2的袁术个数
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }
}