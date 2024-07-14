package other;

import java.util.*;

/**
 * @author Mr.黄
 * @description
 * @since 2023/12/13 21:20
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        List<String> list = new ArrayList<>();
        while (in.hasNextLine()) {
            list.add(in.nextLine());
        }
        Set<String> set = new HashSet<>();
        for (String s : list) {
            if (!s.isEmpty()) {
                Collections.addAll(set, s.split(" "));
            }
        }
        Map<String, String> map = new HashMap<>();

        for (String s : set) {
            if ("(***)".equals(s)) {
                System.out.println("True");
                System.out.println("(***)");
                return;
            }
            if (line1.contains(s)) {
                for (String s1 : set) {
                    if (line2.contains(s1)) {
                        map.put(s, s1);
                    }
                }
            }
        }
        List<String> list1 = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        if (map.isEmpty()) {
            for (String s : set) {
                if (line2.contains(s)) {
                    list1.add(s);
                }
            }
        }
        for (String s : list1) {
            int index = line2.indexOf(s);
            if (line1.length() > index) {
                String substring = line1.substring(index, s.length() + index);
                map1.put(substring, s);
            }
        }


        if (!map.isEmpty()) {
            System.out.println("True");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } else {
            System.out.println("False");
            for (Map.Entry<String, String> entry : map1.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }



    }
}
