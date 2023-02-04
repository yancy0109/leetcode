package leetcodeHot100.q7Reverse;

/**
 * @author yancy0109
 */
public class Solution1 {

    public int reverse(int x) {
        //存储最后结果
        int rev = 0;
        //循环x
        while (x != 0){
            //如果rev下一次增加超出int范围 返回0
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10){
                return 0;
            }
            //保存末尾数字
            int digit = x % 10;
            //更新x的值 去除最后一位
            x /= 10;
            rev = rev * 10 + digit;
        }
        //返回最后结果
        return rev;
    }
    public static void main(String[] args) {
        int input = -2147483412;
        System.out.println(input);
        System.out.println(new Solution1().reverse(input));
    }
}
