package leetcode;

public class Leetcode509 {
    public int fib(int n) {
        int result = 1;
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return result;
        }
        int p = 1;
        int q = 1;
        // result = p + q
        for (int i = 2; i < n; i++) {
            result = p + q;
            p = q;
            q = result;
        }
        return result;
    }
}
