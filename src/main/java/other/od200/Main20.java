package other.od200;

import java.util.*;

/**
 * @author Mr.黄
 * @description 最长的指定瑕疵度的元音子串
 * @since 2024/7/17 19:56
 **/
public class Main20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int num = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            if (set.contains(line.charAt(i))) {
                indexList.add(i);
            }
        }
        int result = 0;
        int n = indexList.size();
        int left = 0;
        int right = 0;
        while (right < n) {
            int diff = indexList.get(right) - indexList.get(left) - (right - left);
            if (diff > num) {
                left++;
            } else if (diff < num) {
                right++;
            } else {
                result = Math.max(result, indexList.get(right) - indexList.get(left) + 1);
                right++;
            }
        }

        System.out.println(result);

    }
}
