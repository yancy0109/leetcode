package offersword.q14cuttingRope;

/**
 * 割绳子
 * 数学推论法
 * @author yancy0109
 */
public class Solution2 {
    public int cuttingRope(int n) {
        // 当n<5  2 3 4
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        // n = 4
        // 当n>=5 -->> 3*(n-3) = 3n-9 ? n
        //                      -->> 2n > 9
        int res = 1;
        while (n>=5) {
            res *= 3;
            n -= 3;
        }
        // 推出循环时 n = 3/4 不需要再切割
        return res * n;
    }



    public static void main(String[] args) {
        System.out.println(new Solution2().cuttingRope(15));
    }
}
