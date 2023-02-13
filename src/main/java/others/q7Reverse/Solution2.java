package others.q7Reverse;

/**
 * @author yancy0109
 */
public class Solution2 {

    public int reverse(int x) {
        boolean flag = false;
        if (x < 0){
            flag = true;
            x = -x;
        }
        //当数字小于10，直接返回
        if (x / 10 == 0){
            return x;
        }
        int total = 1;
        for (int i = 1; i <= x; i*=10){
            total*=10;
        }
        total /= 10;
        //存储当前位数的乘数
        int totalTemp = total;
        int result = 0;
        //先把首位加入到结果中
        result += (x % 10) * totalTemp;
        totalTemp /= 10;
        if (totalTemp == 0){
            totalTemp = 1;
        }
        for (int i = 10; i <= x ; i *= 10){
            int temp = (x / i);
            if (temp >= 10){
                for (int j = total / i; j > 1; j /= 10){
                    temp = temp % j;
                }
            }
            result += temp * totalTemp;
            if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE){
                return 0;
            }
            totalTemp /= 10;
            if (totalTemp == 0){
                totalTemp = 1;
            }
        }
        if (flag){
            return -result;
        }else {
            return result;
        }
    }

    public static void main(String[] args) {
        int input = -2147483412;
        System.out.println(input);
        System.out.println(new Solution2().reverse(input));
    }
}
