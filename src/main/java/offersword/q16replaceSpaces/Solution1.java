package offersword.q16replaceSpaces;

/**
 * ACwing
 * @author yancy0109
 */
public class Solution1 {
    public String replaceSpaces(StringBuffer str) {
        byte[] target = str.toString().getBytes();
        int len = target.length;
        // 记录当前插入偏移量
        int offset = 0;
        // 默认每次插入与原数组偏移量
        final int OFF_LEN = 2;
        for (int i = 0; i < len; i++) {
            if (target[i] == ' ') {
                str.deleteCharAt(i + offset);
                str.insert(i + offset, "%20");
                offset += OFF_LEN;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String str = "We are happy.";
        StringBuffer stringBuffer = new StringBuffer(str);
        System.out.println(new Solution1().replaceSpaces(stringBuffer));
    }
}
