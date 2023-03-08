package offersword.q15hammingWeight;

/**
 * 逐位判断
 * LogN
 * @author yancy0109
 */
public class Solution1 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 11 ;
        System.out.println(new Solution1().hammingWeight(n));
    }

}
