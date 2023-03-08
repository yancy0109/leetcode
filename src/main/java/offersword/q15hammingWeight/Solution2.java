package offersword.q15hammingWeight;

/**
 * n & (n-1)
 * LogN
 * @author yancy0109
 */
public class Solution2 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res ++;
            // 取出n中一位1
            // Eg
            // n    10111
            // n-1  10110  --->> n&(n-1) = 10110
            // n    10100
            // n-1  10011  --->> n&(n-1) = 10000
            n = n & (n -1);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 11 ;
        System.out.println(new Solution2().hammingWeight(n));
    }

}
