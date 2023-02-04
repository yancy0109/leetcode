package leetcodeHot100.q5longestPalindrome;

public class Solution3 {
    /**
     * 动态规划
     */
    public String longestPalindrome(String s){
        int len = s.length();
        if (len < 2)
            return s;
        char[] chars = s.toCharArray();
        //初始化情况
        int MaxLen = 1;
        int begin = 0;
        //dp[i][j] 表示 s[i..j] 是否为回文串
        boolean[][] dp = new boolean[len][len];
        //当 i=j 时 单个字符自定为子字符串
        for (int i = 0; i < len; i++)
            dp[i][i] = true;
        //左下角先开始
        for (int j = 1; j < len; j++){
            for (int i = 0; i < j; i++){
                if (chars[i] != chars[j]){
                    dp[i][j] = false;
                }else{
                    //当前串内的串 长度为 0 / 1 则不需要继续向下判断
                    if ((j-1) - (i+1) +1 < 2){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                //判断每一次结果 更新最大值
                if (dp[i][j] == true){
                    if (j - i + 1 > MaxLen){
                        begin = i;
                        MaxLen = j - i +1;
                    }
                }
            }
        }
        return s.substring(begin,begin+MaxLen);
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().longestPalindrome("asbabsa"));
    }
}
