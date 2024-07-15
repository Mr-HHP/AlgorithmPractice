package other.od100;

import java.util.*;
import java.util.function.ToIntFunction;

/**
 * @author Mr.黄
 * @description 整数对最小和
 * @since 2024/7/14 14:41
 **/
public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        int k = scanner.nextInt();
        int[] array1 = Arrays.stream(line1.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] array2 = Arrays.stream(line2.split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> group = new ArrayList<>();
        for (int i = 1; i < array1.length; i++) {
            for (int j = 1; j < array2.length; j++) {
                group.add(array1[i] + array2[j]);
            }
        }
        Collections.sort(group);
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += group.get(i);
        }
        System.out.println(sum);
    }
}
