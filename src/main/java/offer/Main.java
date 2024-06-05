package offer;

import java.text.FieldPosition;
import java.util.*;

/**
 * @author Mr.黄
 * @date 2022/04/04
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.next();
        in.nextLine();
        String[] vlanPool = in.nextLine().split(",");
        int needVlan = in.nextInt();
        List<Integer> list = new ArrayList<>();
        for (String vlan : vlanPool) {
            String[] split = vlan.split("-");
            if (split.length > 1) {
                for (int i = Integer.valueOf(split[0]); i <= Integer.valueOf(split[1]); i++) {
                    System.out.println(i);
                    list.add(i);
                }
            } else {
                list.add(Integer.parseInt(split[0]));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (needVlan == list.get(i)) {
                list.remove(i);
            }
        }
        StringBuilder result = new StringBuilder();
        Collections.sort(list);
        int i = 0;
        while (i < list.size()) {
            int j = 1;
            int first = list.get(i);
            while (j <= list.size() - 1 - i) {
                if (list.get(i + j) == list.get(i) + j) {
                    j++;
                } else {
                    break;
                }
            }
            if (j == 1) {
                result.append(first).append(",");
                i++;
            } else {
                result.append(first).append("-").append((first + j - 1)).append(",");
                i = i + j;
            }
        }
        if (result.length() == 0) {
            System.out.println(0);
        } else {
            System.out.println(result.toString().substring(0, result.length() - 1));
        }
    }
}