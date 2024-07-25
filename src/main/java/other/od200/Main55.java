package other.od200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 推荐多样性
 * @since 2024/7/25 18:08
 **/
public class Main55 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        List<List<Integer>> lists = new ArrayList<>();
        List<List<Integer>> windows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            windows.add(new ArrayList<>());
        }
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            List<Integer> currentList = new ArrayList<>();
            int[] ints = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int num : ints) {
                currentList.add(num);
            }
            lists.add(currentList);
        }
        int[] index = new int[lists.size()];
        int nowList = 0;
        for (int i = 0; i < k; i++) {
            int start = nowList;
            for (int j = 0; j < n; j++) {
                while (index[nowList] >= lists.get(nowList).size()) {
                    nowList = (nowList + 1) % lists.size();
                }
                windows.get(j).add(lists.get(nowList).get(index[nowList]));
                index[nowList]++;
            }
            if (i == k - 1) {
                break;
            }
            if (start == nowList) {
                int next = (nowList + 1) % lists.size();
                while (index[next] >= lists.get(next).size()) {
                    next = (next + 1) % lists.size();
                }
                nowList = next;
            }
        }
        for (List<Integer> window : windows) {
            for (int num : window) {
                System.out.print(num + " ");
            }
        }
    }
}
