package offer;

import java.util.*;

/**
 * 运行主类
 *
 * @author Mr.黄
 * @date 2021/10/10
 **/
public class RunMain {
    public static void main(String[] args) {
//        main1(null);
//        System.out.println((int) 'a');
//        System.out.println((int) 'z');
        System.out.println(getNum(47));
        System.out.println(getNum(48));
        System.out.println(getNum(49));
        System.out.println((97 + (122 - 97) % 26));
        System.out.println((97 + (123 - 97) % 26));
        System.out.println((97 + (124 - 97) % 26));
        System.out.println((97 + (200 - 97) % 26));
        System.out.println((97 + (300 - 97) % 26));
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            char[] chars = str.toCharArray();
            for (int j = 0; j < str.length(); j++) {
                long num = chars[j] + getNum(j);
                if (num >= 97 && num <= 122) {
                    chars[j] = (char) (num);
                } else {
                    chars[j] = (char) ((num - 'a') % 26 + 'a');
                }
            }
            result.add(String.valueOf(chars));
        }
        for (String s : result) {
            System.out.println(s);
        }
    }
    
    private static long getNum(int num) {
        long a1 = 1, a2 = 2, a3 = 4, a4 = 0;
        if (num == 0) {
            return a1;
        } else if (num == 1) {
            return a2;
        } else if (num == 2) {
            return a3;
        } else {
            for (int i = 3; i <= num; i++) {
                a4 = a1 + a2 + a3;
                a1 = a2;
                a2 = a3;
                a3 = a4;
            }
            return a4;
        }
    }
}