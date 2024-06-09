package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Mr.黄
 * @description 合并区间
 * @since 2024/6/9 15:59
 **/
public class LeetCode56 {
    // [[1,3],[2,6],[8,10],[15,18]]
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int i = 0;
        List<int[]> result = new ArrayList<>();
        while (i < intervals.length) {
            int j = i + 1;
            int left = intervals[i][0];
            int right = intervals[i][1];
            int[] temp = new int[]{left, right};
            while (j < intervals.length && intervals[j][0] <= right) {
                right = Math.max(right, intervals[j][1]);
                temp[1] = right;
                j++;
            }
            result.add(temp);
            i = j;
        }
        int[][] arr = new int[result.size()][2];
        return result.toArray(arr);
    }
}
