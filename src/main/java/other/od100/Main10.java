package other;

import java.util.*;
import java.util.function.ToIntFunction;

/**
 * @author Mr.黄
 * @description 寻找最富裕的小家庭
 * @since 2024/7/14 16:20
 **/
public class Main10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = Integer.parseInt(scanner.nextLine());
            int[] moneys = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Map<Integer, List<Integer>> family = new HashMap<>();
            for (int i = 0; i < n - 1; i++) {
                String line = scanner.nextLine();
                int parent = Integer.parseInt(line.split(" ")[0]);
                int child = Integer.parseInt(line.split(" ")[1]);
                List<Integer> childs = family.getOrDefault(parent, new ArrayList<>());
                childs.add(child);
                family.put(parent, childs);
            }
            int maxMoney = Integer.MIN_VALUE;
            for (Map.Entry<Integer, List<Integer>> entry : family.entrySet()) {
                List<Integer> childList = entry.getValue();
                Integer parent = entry.getKey();
                int money = moneys[parent - 1];
                for (int child : childList) {
                    money += moneys[child - 1];
                }
                if (money > maxMoney) {
                    maxMoney = money;
                }
            }
            System.out.println(maxMoney);
        }
    }
}