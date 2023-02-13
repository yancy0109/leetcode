package others.q7Reverse;

/**
 * @author yancy0109
 */
public class App {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            // result进位
            result*=10;
            // result + 当前x末尾
            result+=x%10;
            // x移除末位
            x/=10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new App().reverse(-2147483415));
    }
}
