package other;

import java.util.*;

/**
 * @author Mr.黄
 * @description 机场航班调度程序
 * @since 2024/7/15 0:19
 **/
public class Main20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] flightNums = scanner.nextLine().split(",");
        Arrays.sort(flightNums, (str1, str2) -> {
            if (str1.charAt(0) == str2.charAt(0)) {
                if (str1.charAt(1) == str2.charAt(1)) {
                    return Integer.parseInt(str1.substring(2)) - Integer.parseInt(str2.substring(2));
                } else {
                    return str1.charAt(1) - str2.charAt(1);
                }
            }
            return str1.charAt(0) - str2.charAt(0);
        });
        StringBuffer sb = new StringBuffer();
        for (String fightNum : flightNums) {
            sb.append(fightNum);
            sb.append(",");
        }
        if (flightNums.length > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb);
    }
}

