package offersword.q20Fibonacci;

/**
 * 斐波那契数列
 * 递归法，可以使用记忆化搜索记录计算的结果
 * @author yancy0109
 */
public class Solution1 {
    public int Fibonacci(int n) {
        int MOD = 1000000007;
        if (n ==0 || n ==1) {
            return n;
        }
        return (Fibonacci(n-1) + Fibonacci(n -2)) % MOD;
    }
}
