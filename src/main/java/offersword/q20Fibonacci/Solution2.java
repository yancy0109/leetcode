package offersword.q20Fibonacci;

/**
 * 斐波那契数列
 * 动态规划，递推法
 * @author yancy0109
 */
public class Solution2 {
    public int Fibonacci(int n) {
        int len = n;
        int MOD = 1000000007;
        if (len < 2) {
            return len;
        }
        int[] store = new int[n + 1];
        store[0] = 0;
        store[1] = 1;
        for (int i = 2; i <= n; i++) {
            store[i] = (store[i-1] + store[i-2]) % MOD;
        }

        return store[n];
    }

}
