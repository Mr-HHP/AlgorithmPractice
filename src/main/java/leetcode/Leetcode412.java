package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Fizz Buzz
 *
 * @author Mr.黄
 * @date 2022/04/21
 **/
public class Leetcode412 {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((i + 1) % 3 == 0 && (i + 1) % 5 == 0) {
                answer.add("FizzBuzz");
            } else if ((i + 1) % 3 == 0) {
                answer.add("Fizz");
            } else if ((i + 1) % 5 == 0) {
                answer.add("Buzz");
            } else {
                answer.add(String.valueOf(i + 1));
            }
        }
        return answer;
    }
}