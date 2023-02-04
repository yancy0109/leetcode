package leetcodeHot100.q3lengthOfLongestSubstring;

import java.util.HashSet;

/**
 *滑动窗口
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        //当前字符串长度
        int sLength = s.length();
        //HashSet
        HashSet hashSet = new HashSet();
        //记录最长长度
        int length = 0;
        //记录滑动窗口右指针
        int index = 0;
        for (int i = 0; i < sLength; i++){
            //当i!=0的情况下 i++即为滑动窗口右移，所以要移除i-1
            if (i != 0){
                hashSet.remove(s.charAt(i-1));
            }
            //滑动窗口右边界扩展至不含有重复元素
            while (index < sLength){
                //如果HashSet不包含s.charAt(inedx) 移动窗口右边界
                if (!hashSet.contains(s.charAt(index))){
                    hashSet.add(s.charAt(index));
                    length = Math.max(length,index-i+1);
                    index++;
                }else {
                    //当右边界移动会出现重复元素，则会重复出发窗口左移，
                    //直至不含有重复元素
                    break;
                }
            }
        }
        return length;
    }


    public static void main(String[] args) {
        System.out.println(new Solution1().lengthOfLongestSubstring("pwwkew"));
    }
}
