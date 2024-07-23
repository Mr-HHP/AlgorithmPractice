package other.od200;

import java.util.*;

/**
 * @author Mr.黄
 * @description 最长的指定瑕疵度的元音字串
 * @since 2024/7/22 11:51
 **/
public class Main38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int flaw = Integer.parseInt(scanner.nextLine());
        String[] words = scanner.nextLine().split("");
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("e");
        set.add("i");
        set.add("o");
        set.add("u");
        set.add("A");
        set.add("E");
        set.add("I");
        set.add("O");
        set.add("U");
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (set.contains(words[i])) {
                indexList.add(i);
            }
        }
        int result = 0;
        int left = 0;
        int right = 0;
        while (right < indexList.size()) {
            int diff = indexList.get(right) - indexList.get(left) - (right - left);
            if (diff > flaw) {
                left++;
            } else if (diff < flaw) {
                right++;
            } else {
                result = Math.max(result, indexList.get(right) - indexList.get(left) + 1);
                right++;
            }
        }
        System.out.println(result);
    }
}
