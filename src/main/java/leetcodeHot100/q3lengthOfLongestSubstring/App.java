package leetcodeHot100.q3lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yancy0109
 */
public class App {

    //滑动窗口（适用字串）
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        char[] charArray = s.toCharArray();
        // 左边界
        int left = 0;
        // 最大长度
        int maxLength = 0;
        // (char, index) 记录对应字符在s中出现的位置
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            // 若下一元素与当前队列重复
            if (hashMap.containsKey(charArray[i])) {
                // 当前重复元素并非
                if (hashMap.get(charArray[i]) < left) {
                    // 存入当前字符及位置
                    hashMap.put(charArray[i], i);
                    // 更新最大值
                    maxLength = Math.max(maxLength, i-left+1);
                    continue;
                }
                // 若重复元素为窗口内内元素，窗口左边界排除重复元素的下一个元素
                // 当 abc a ----> left = HashMap.get(a)+1
                // 若如果重复元素为窗口外的元素，窗口不变
                // 当 ab --》 b a ----> 因为之前存在过a，所以 left = left
                left = Math.max(left, hashMap.get(charArray[i])+1);
//                left = hashMap.get(charArray[i])+1;
            }
            // 存入/更新当前字符及位置   ----》 使得HashMap同一元素只能存在一个
            hashMap.put(charArray[i], i);
            // 更新最大值
            maxLength = Math.max(maxLength, i-left+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String testString = "abcabcxsaxasxsdasdasdssjidjaisjioabb";
        System.out.println(new App().lengthOfLongestSubstring(testString));
    }
}
