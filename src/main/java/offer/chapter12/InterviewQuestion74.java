package offer.chapter12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题74：合并区间
 * 输入一个区间的集合，请将重叠的区间合并。每个区间用两个数字比较，分别表示区间的起始位置和结束位置
 *
 * @author Mr.黄
 * @date 2022/05/14
 **/
public class InterviewQuestion74 {
    public static void main(String[] args) {
        InterviewQuestion74 interviewQuestion74 = new InterviewQuestion74();
        int[][] intervals = new int[][]{{1, 3}, {4, 5}, {8, 10}, {2, 6}, {9, 12}, {15, 18}};
        int[][] merge = interviewQuestion74.merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < merge[0].length; j++) {
                System.out.println(merge[i][j]);
            }
            System.out.println();
        }
    }
    
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        List<int[]> merged = new LinkedList<>();
        int i = 0;
        while (i < intervals.length) {
            int[] temp = new int[]{intervals[i][0], intervals[i][1]};
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] <= temp[1]) {
                temp[1] = Math.max(temp[1], intervals[j][1]);
                j++;
            }
            merged.add(temp);
            i = j;
        }
        int[][] result = new int[merged.size()][];
        return merged.toArray(result);
    }
    
    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        List<int[]> merged = new LinkedList<>();
        int i = 0;
        while (i < intervals.length) {
            int[] temp = new int[]{intervals[i][0], intervals[i][1]};
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] <= temp[1]) {
                // 区间2的头小于等于区间1的尾
                temp[1] = Math.max(intervals[j][1], temp[1]);
                j++;
            }
            merged.add(temp);
            i = j;
        }
        int[][] result = new int[merged.size()][];
        return merged.toArray(result);
    }
}