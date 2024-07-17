package other.od200;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Mr.黄
 * @description 中文分词模拟器
 * @since 2024/7/17 11:43
 **/
public class Main13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Set<String> dictionaries = new HashSet<>();
        int maxLength = 0;
        for (String word : scanner.nextLine().split(",")) {
            dictionaries.add(word);
            maxLength = Math.max(word.length(), maxLength);
        }
        StringBuffer sb = new StringBuffer();
        for (int left = 0; left < str.length(); left++) {
            if (str.charAt(left) < 'a' || str.charAt(left) > 'z') {
                continue;
            }
            int p = left;
            StringBuffer tmp = new StringBuffer();
            tmp.append(str.charAt(left));
            for (int right = left + 1; right - left + 1 <= maxLength && right < str.length(); right++) {
                tmp.append(str.charAt(right));
                if (dictionaries.contains(tmp.toString())) {
                    p = right;
                }
            }
            tmp.setLength(p - left + 1);
            dictionaries.remove(tmp.toString());
            sb.append(tmp).append(",");
            left = p;
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
