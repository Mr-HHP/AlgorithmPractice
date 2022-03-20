package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @author Mr.黄
 * @date 2022/03/20
 **/
public class Leetcode22 {
    List<String> res = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        getParenthesis(sb, n, n);
        return res;
    }
    
    private void getParenthesis(StringBuilder str, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(str.toString());
            return;
        }
        // 剪枝（左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left == right) {
            //剩余左右括号数相等，下一个只能用左括号
            getParenthesis(str.append("("), left - 1, right);
            str.deleteCharAt(str.length() - 1);
        } else if (left < right) {
            //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
            if (left > 0) {
                getParenthesis(str.append("("), left - 1, right);
                str.deleteCharAt(str.length() - 1);
            }
            getParenthesis(str.append(")"), left, right - 1);
            str.deleteCharAt(str.length() - 1);
        }
    }
}