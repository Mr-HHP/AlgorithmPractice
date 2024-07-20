package other.od100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 考勤信息
 * @since 2024/7/20 21:00
 **/
public class Main35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String[] split = scanner.nextLine().split(" ");
            boolean flag = true;
            int absentCount = 0;
            for (int j = 0; j < split.length; j++) {
                if ("leaveearly".equals(split[j])) {
                    split[j] = "late";
                }
                if ("absent".equals(split[j])) {
                    absentCount++;
                }
                if (j >= 1 && "late".equals(split[j]) && "late".equals(split[j - 1])) {
                    flag = false;
                }
                if (j >= 6) {
                    int presentCount = 0;
                    for (int k = 0; k < 7; k++) {
                        presentCount += "presentCount".equals(split[j - k]) ? 1 : 0;
                    }
                    if (presentCount < 4) {
                        flag = false;
                    }
                }
            }
            if (absentCount > 1) {
                flag = false;
            }
            result.add(flag ? "true" : "false");
//            System.out.print(flag ? "true " : "false ");
        }
        System.out.println(String.join(" ", result));
    }
}
