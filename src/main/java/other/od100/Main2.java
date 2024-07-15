package other;

import java.util.*;

/**
 * @author Mr.黄
 * @description 围棋的气
 * @since 2024/7/13 13:52
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> blacks = buildCoord(scanner.nextLine().split(" "));
        List<String> whites = buildCoord(scanner.nextLine().split(" "));
        System.out.println(count(blacks, whites) + " " + count(whites, blacks));
    }

    public static int count(List<String> list1, List<String> list2) {
        Set<String> set = new HashSet<>();
        for (String coord : list1) {
            set.add(coord);
            int x = Integer.parseInt(coord.split("_")[0]);
            int y = Integer.parseInt(coord.split("_")[1]);
            if (x > 0) {
                String left = (x - 1) + "_" + y;
                set.add(left);
            }
            if (x < 18) {
                String right = (x + 1) + "_" + y;
                set.add(right);
            }
            if (y > 0) {
                String down = x + "_" + (y - 1);
                set.add(down);
            }
            if (y < 18) {
                String up = x + "_" + (y + 1);
                set.add(up);
            }
        }
        int count = set.size() - list1.size();
        for (String coord : list2) {
            if (set.contains(coord)) {
                count--;
            }
        }
        return count;
    }

    public static List<String> buildCoord(String[] array) {
        List<String> coords = new ArrayList<>();
        for (int i = 0; i < array.length; i += 2) {
            String x = array[i];
            String y = array[i + 1];
            coords.add(x + "_" + y);
        }
        return coords;
    }

}
