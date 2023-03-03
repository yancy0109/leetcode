package leetcodeHot100.q10isMatch;

/**
 * 正则表达式匹配
 * @author yancy0109
 */
public class Solution1 {

    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        int indexS = 0;
        int indexP = 0;
        while (indexS < lenS || indexP < lenP) {
            // 如果char为 . / *
            char c = p.charAt(indexP);
            // 如果为通配符
            if(c == '.') {
                indexS++;
                continue;
            }
            if(c == '*') {
                if (indexP == lenP-1) {
                    return true;
                }
                // 将指针挪匹配项的下一项
                while (s.charAt(indexS) != p.charAt(indexP)) {

                }
                indexP++;
                continue;
            }
            if (s.charAt(indexS) != s.charAt(indexP)) {
                return false;
            }
            indexS++;
            indexP++;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().isMatch("aa", "a*"));
    }
}
