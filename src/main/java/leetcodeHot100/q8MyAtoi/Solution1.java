package leetcodeHot100.q8MyAtoi;

/**
 * @author yancy0109
 */
public class Solution1 {

    //todo 我不想玩了

    public int myAtoi(String s) {
        int flag = 1;
        char[] chars = s.toCharArray();
        int length = chars.length;
        int index = 0;
        int rev = 0;
        int hasRead = 0;
        while (index <= length-1){
            char temp = chars[index];
            if (!(temp == ' ' || temp == '-' || temp == '+' || temp >= '0' && temp <= '9')){
                return rev*flag;
            }
            if (temp == ' '){
                if (hasRead == 1){
                    return rev*flag;
                }
                index++;
                continue;
            }
            if (temp == '-'){
                if (hasRead == 1){
                    return rev*flag;
                }
                flag = -1;
                hasRead = 1;
            }
            if (temp == '+'){
                if (hasRead == 1){
                    return rev*flag;
                }
                hasRead = 1;
            }
            if (temp > '9' || temp < '0'){
                index++;
                continue;
            }
            if (temp <= '9' || temp >= '0'){
                hasRead = 1;
                if (Integer.MAX_VALUE - temp + '0' < rev * 10) {
                    if (flag == 1){
                        return Integer.MAX_VALUE;
                    }else {
                        return Integer.MIN_VALUE;
                    }
                }
                rev = rev * 10 + temp - '0';
            }
            index++;
        }
        return rev * flag;
    }
    public static void main(String[] args) {
        String input = "2147483646";
        System.out.println(new Solution1().myAtoi(input));

    }
}
