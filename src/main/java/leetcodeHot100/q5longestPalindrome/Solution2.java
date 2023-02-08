package leetcodeHot100.q5longestPalindrome;

public class Solution2 {
    /**
     * 中心扩散法
     */
    public String longestPalindrome(String s){
        int len = s.length();
        if (len < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char [] chars = s.toCharArray();
        // i为中心位置
        for (int i = 0; i < len-1; i++){
            // 以中心位置为奇数长度子串扩散
            int len1 = expandAroundCenter(chars,i,i);
            // 以中心位置为偶数长度字串扩散
            int len2 = expandAroundCenter(chars,i,i+1);
            // 比较获得最大长度
            int curMaxLen = Math.max(len1,len2);
            if (curMaxLen > maxLen){
                maxLen = curMaxLen;
                begin = i-(curMaxLen-1)/2;
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    /**
     * 传入字符串与中心点位置
     * 向两边扩展出最长回文字串长度
     * 适用于奇数/偶数子串
     * 奇数子串相等于比较了同一位置再扩散
     * @param chars
     * @param left
     * @param right
     * @return
     */
    public int expandAroundCenter(char[] chars,int left,int right){
        //left==right时为奇数子串
        //left<right时为偶数子串
        int len = chars.length;
        while (left >= 0 && right < len){
            if (chars[left]==chars[right]){
                left--;
                right++;
            }else {
                break;
            }
        }
        //退出循环时 left+1  ---- riht-1 为字串
        return (right-1)-(left+1)+1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().longestPalindrome("ccc"));
    }
}
