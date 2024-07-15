package other.od200;

import java.util.*;

/**
 * @author Mr.黄
 * @description 石头剪刀布游戏
 * @since 2024/7/15 22:22
 **/
public class Main10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> map = new HashMap<>();
        map.put("A", new ArrayList<>());
        map.put("B", new ArrayList<>());
        map.put("C", new ArrayList<>());

        while (true) {
            String line = scanner.nextLine();
            if (line.length() == 0) {
                break;
            }
            String[] split = line.split(" ");
            String name = split[0];
            String gameType = split[1];
            List<String> list = map.get(gameType);
            if (list == null) {
                System.out.println("NULL");
                return;
            }
            list.add(name);
        }
        List<String> listA = map.get("A");
        List<String> listB = map.get("B");
        List<String> listC = map.get("C");
        int count = 0;
        if (listA.size() != 0) {
            count++;
        }
        if (listB.size() != 0) {
            count++;
        }
        if (listC.size() != 0) {
            count++;
        }
        if (count == 2) {
            if (listA.size() == 0) {
                Collections.sort(listB);
                for (String name : listB) {
                    System.out.println(name);
                }
            }
            if (listB.size() == 0) {
                Collections.sort(listC);
                for (String name : listC) {
                    System.out.println(name);
                }
            }
            if (listC.size() == 0) {
                Collections.sort(listA);
                for (String name : listA) {
                    System.out.println(name);
                }
            }
        } else {
            System.out.println("NULL");
        }
    }
}
