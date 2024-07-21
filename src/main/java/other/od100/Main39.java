package other.od100;

import java.util.*;

/**
 * @author Mr.黄
 * @description 英文输入法
 * @since 2024/7/21 11:05
 **/
public class Main39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String prefix = scanner.nextLine();
        str = str.replaceAll("[^\\w\\s]", " ");
        Set<String> wordSet = new HashSet<>(Arrays.asList(str.split(" ")));
        TreeSet<String> result = new TreeSet<>();
        for (String word : wordSet) {
            if (word.startsWith(prefix.trim())) {
                result.add(word);
            }
        }
        System.out.println(String.join(" ", result));
    }
}
