package leetcodeHot100.q5longestPalindrome;

public class Solution1 {
    /**
     * 暴力解法
     * 最长回文子序列
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s){
        int len = s.length();
        //若长度小于2 则直接返回当前串
        if (len < 2)
            return s;
        //将字符串转化为字符数组
        char[] chars = s.toCharArray();
        //记录初始最大值    ---- 即回文串为 chars[0]
        int maxLen = 1;
        //记录开始位置
        int begin = 0;
        //i 存储左端位置
        for (int i = 0; i < len-1; i++){
            //j 记录右端位置
            for (int j = i + 1; j < len; j++){
                //若当前串大于回文串最大值 && 当前串是回文串
                if (j-i+1 > maxLen && isLong(chars,i,j)){
                    //更新最大值
                    maxLen = j-i+1;
                    //更新最大回文串左端位置
                    begin = i;
                }
            }
        }
        //返回回文串
        return s.substring(begin,begin+maxLen);
    }

    /**
     * 判断传入字符串数组是否为回文串
     * @param string
     * @param left
     * @param right
     * @return
     */
    public boolean isLong(char [] string, int left, int right){
        while (left<right){
            if (string[left] == string[right]){
                left++;
                right--;
            }
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().longestPalindrome("accaas"));
    }

}
