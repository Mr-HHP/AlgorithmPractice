package other.od100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 万能字符单词拼写
 * @since 2024/7/14 23:08
 **/
public class Main16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine());
        }
        String chars = scanner.nextLine();
        int count = 0;
        int[] charCount = new int[26];
        int wildcardCount = 0;
        for (char c : chars.toCharArray()) {
            if (c == '?') {
                wildcardCount++;
            } else {
                charCount[c - 'a']++;
            }
        }
        for (String word : words) {
            if (help(word, charCount, wildcardCount)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean help(String word, int[] charCount, int wildcardCount) {
        int[] wordCount = new int[26];
        for (char c : word.toCharArray()) {
            wordCount[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (wordCount[i] > charCount[i]) {
                int diff = wordCount[i] - charCount[i];
                if (wildcardCount >= diff) {
                    wildcardCount -= diff;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
