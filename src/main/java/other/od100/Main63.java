package other.od100;

import java.util.*;

/**
 * @author Mr.黄
 * @description 幼儿园篮球游戏
 * @since 2024/7/24 16:39
 **/
public class Main63 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(",");
        Deque<Integer> deque = new ArrayDeque<>();
        Queue<Integer> a = new LinkedList<>();
        for (String num : nums) {
            a.add(Integer.parseInt(num));
        }
        int[] b = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        StringBuffer sb = new StringBuffer();
        boolean flag = true;
        for (int x : b) {
            while (flag) {
                if (deque.size() > 0 && deque.peekFirst() == x) {
                    deque.pollFirst();
                    sb.append("L");
                    break;
                } else if (deque.size() > 0 && deque.peekLast() == x) {
                    deque.pollLast();
                    sb.append("R");
                    break;
                } else if (a.size() > 0) {
                    deque.offerLast(a.poll());
                } else {
                    flag = false;
                }
            }
            if (!flag) {
                break;
            }
        }
        System.out.println(flag ? sb.toString() : "NO");
    }
}
