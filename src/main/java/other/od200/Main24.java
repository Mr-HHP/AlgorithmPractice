package other.od200;

import java.util.*;

/**
 * @author Mr.黄
 * @description 解密犯罪时间
 * @since 2024/7/19 15:22
 **/
public class Main24 {
    public static List<Integer> now;
    public static List<Integer> last;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Set<Integer> num = new TreeSet<>();
        num.add(line.charAt(0) - '0');
        num.add(line.charAt(1) - '0');
        num.add(line.charAt(3) - '0');
        num.add(line.charAt(4) - '0');
        last = new ArrayList<>();
        int hour = Integer.parseInt(line.split(":")[0]);
        int minute = Integer.parseInt(line.split(":")[1]);
        last.add(hour);
        last.add(minute);
        now = new ArrayList<>(last);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        dfs(list, 0, num);
        System.out.printf("%02d:%02d%n", now.get(0), now.get(1));
    }

    public static boolean check(List<Integer> list) {
        return list.get(0) < 24 && list.get(1) < 60;
    }

    public static int calculate(List<Integer> list1, List<Integer> list2) {
        int hour = list2.get(0) - list1.get(0);
        int minute = list2.get(1) - list1.get(1);
        if (minute < 0) {
            minute += 60;
            hour--;
        }
        if (hour < 0) {
            hour += 24;
        }
        int result = hour * 60 + minute;
        if (result == 0) {
            result = 24 * 60;
        }
        return result;
    }

    public static void dfs(List<Integer> list, int p, Set<Integer> num) {
        if (p == 4) {
            if (check(list) && calculate(last, list) < calculate(last, now)) {
                now = new ArrayList<>(list);
            }
            return;
        }
        for (int i : num) {
            List<Integer> tmp = new ArrayList<>(list);
            if (p == 0) {
                list.set(0, list.get(0) + 10 * i);
            } else if (p == 1) {
                list.set(0, list.get(0) + i);
            } else if (p == 2) {
                list.set(1, list.get(1) + 10 * i);
            } else {
                list.set(1, list.get(1) + i);
            }
            dfs(list, p + 1, num);
            list = new ArrayList<>(tmp);
        }
    }
}
