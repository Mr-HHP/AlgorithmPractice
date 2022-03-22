package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author Mr.黄
 * @date 2022/03/23
 **/
public class Leetcode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    line.add(1);
                } else {
                    line.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(line);
        }
        return result;
    }
}