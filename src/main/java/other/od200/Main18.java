package other.od200;

import java.util.*;

/**
 * @author Mr.黄
 * @description 最长子字符串的长度（二）
 * @since 2024/7/17 18:20
 **/
public class Main18 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int n = line.length();
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int countL = 0;
            int countO = 0;
            int countX = 0;
            for (int j = 0; j < n; j++) {
                int index = (i + j) % n;
                char ch = line.charAt(index);
                if (ch == 'l') {
                    countL++;
                } else if (ch == 'o') {
                    countO++;
                } else if (ch == 'x') {
                    countX++;
                }
                if (countL % 2 == 0 && countO % 2 == 0 && countX % 2 == 0) {
                    maxLength = Math.max(maxLength, j + 1);
                }
            }
        }
        System.out.println(maxLength);
    }
    /*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int countL = 0;
        int countO = 0;
        int countX = 0;
        for (char c : s.toCharArray()) {
            if (c == 'l') {
                countL++;
            } else if (c == 'o') {
                countO++;
            } else if (c == 'x') {
                countX++;
            }
        }
        countL %= 2;
        countO %= 2;
        countX %= 2;
        if (countL + countO + countX == 0) {
            System.out.println(s.length());
        } else {
            int minLength = s.length();
            s = s + s;
            Map<List<Integer>, Integer> map = new HashMap<>();
            int nowL = 0;
            int nowO = 0;
            int nowX = 0;
            map.put(Arrays.asList(0, 0, 0), -1);
            for (int i = 0; i < s.length(); i++) {
                nowL += s.charAt(i) == 'l' ? 1 : 0;
                nowO += s.charAt(i) == 'o' ? 1 : 0;
                nowX += s.charAt(i) == 'x' ? 1 : 0;
                nowL %= 2;
                nowO %= 2;
                nowX %= 2;
                int lastL = nowL ^ countL;
                int lastO = nowO ^ countO;
                int lastX = nowX ^ countX;
                if (map.containsKey(Arrays.asList(lastL, lastO, lastX))) {
                    minLength = Math.min(minLength, i - map.get(Arrays.asList(lastL, lastO, lastX)));
                }
                map.put(Arrays.asList(lastL, lastO, lastX), i);
            }
            int result = s.length() / 2 - minLength;
            System.out.println(result);
        }
    }
     */
}
