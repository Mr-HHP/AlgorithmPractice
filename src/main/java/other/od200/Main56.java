package other.od200;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Mr.黄
 * @description 数据单元的变化替换
 * @since 2024/7/25 18:32
 **/
public class Main56 {
    static String[] cells;
    static Pattern pattern = Pattern.compile("<.*?>");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        cells = scanner.nextLine().split(",");
        if (cells.length > 26) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < cells.length; i++) {
            if (!changeCell(i)) {
                System.out.println(-1);
                return;
            }
            if (cells[i].length() > 100) {
                System.out.println(-1);
                return;
            }
            if (!cells[i].matches("^[a-zA-Z0-9]+$")) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(String.join(",", cells));
    }

    public static boolean changeCell(int index) {
        Matcher matcher = pattern.matcher(cells[index]);
        while (matcher.find()) {
            String reference = matcher.group();
            if (reference.length() != 3) {
                return false;
            }
            char referenceNum = reference.charAt(1);
            char currentNum = (char) (65 + index);
            if (referenceNum < 'A' || referenceNum > 'Z' || referenceNum == currentNum) {
                return false;
            }
            int referenceIndex = referenceNum - 'A';
            if (referenceIndex >= cells.length) {
                return false;
            }
            if (!changeCell(referenceIndex)) {
                return false;
            }
            cells[index] = cells[index].replace(reference, cells[referenceIndex]);
        }
        return true;
    }
}
