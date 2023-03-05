package offersword.q20Fibonacci;

/**
 * 斐波那契数列
 * 动态规划 + 滚动数组
 * @author yancy0109
 */
public class Solution3 {

    // 动态规划 + 滚动数组
    public int Fibonacci(int n) {
        int MOD = 1000000007;
        if (n < 2) {
            return n;
        }
        // 因为其实只需要前两个值，只记录两个值即可
        int x, y, z = 0;
        x = 0;
        y = 1;
        for (int i = 2; i < n+1; i++) {
            z = (x + y) % MOD;
            x = y;
            y = z;
        }
        return z;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().Fibonacci(45));
    }
}
