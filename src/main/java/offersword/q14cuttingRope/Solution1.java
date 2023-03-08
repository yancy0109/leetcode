package offersword.q14cuttingRope;

/**
 * 割绳子
 * DP
 * @author yancy0109
 */
public class Solution1 {
    public int cuttingRope(int n) {
        // 将长度为i进行割绳子后得到的最大值
        int[] dp = new int[n+1];
        // 0 / 1 长度不能被计算
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            //  记录当前长度下不同切割方法最大值
            int result = 0;
            // 可以从i中切割下1至i-1长度绳子
            for (int x = 1; x < i; x++) {
                int s = i - x;
                // 如果分割 s
                int e = x * dp[s];
                // 如果不分割 s
                result = Math.max(result, Math.max(e, s*x));
            }
            dp[i] = result;
        }
        return dp[n];
    }



    public static void main(String[] args) {
        System.out.println(new Solution1().cuttingRope(15));
    }
}
