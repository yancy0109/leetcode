package leetcodeHot100.q5longestPalindrome;

/**
 * 滑动窗口暴力遍历
 * @author yancy0109
 */
public class App1 {
    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        int windowLength = 1;
        int maxStrlength = 1;
        int maxStrPoint = 0;
        // 不断扩大窗口大小
        for (; windowLength <= length; windowLength++) {
            // 减枝
            if (windowLength == 1) {
                continue;
            }
            // 让窗口在字符串上滑动，如果为最大字串，则更新
            int leftIndex = 0;
            while (leftIndex < length) {
                // 剪枝 窗口大小不足，结束当前循环
                if (leftIndex + windowLength > length) {
                    break;
                }
                int leftTempIndex = leftIndex;
                // 窗口右端位置
                int rightIndex = leftTempIndex + windowLength - 1;
                // 遍历判断窗口内是否为回文串
                while (leftTempIndex <= rightIndex) {
                    if (charArray[leftTempIndex] != charArray[rightIndex]) {
                        break;
                    }
                    leftTempIndex++;
                    rightIndex--;
                }
                // 说明当前为合法回文子字串，更新记录值
                if (leftTempIndex > rightIndex) {
                    maxStrlength = windowLength;
                    maxStrPoint = leftIndex;
                    // 一旦当前窗口发现一个可行值 就不需要再滑动
                    break;
                }
                leftIndex++;
            }
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < maxStrlength; i++) {
            buffer.append(charArray[maxStrPoint++]);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(new App1().longestPalindrome("sdasdasbs"));
    }
}
