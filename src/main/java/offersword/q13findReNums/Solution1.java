package offersword.q13findReNums;

import java.util.HashMap;

/**
 * 13. 找出数组中重复的数字
 * HashMap  -->  HashSet更合适
 * @author yancy0109
 */
public class Solution1 {
    public int duplicateInArray(int[] nums) {
        int len = nums.length;
        // 空数组则返回
        if (len == 0) {
            return -1;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0 || nums[i] > len-1) {
                return -1;
            }
        }
        // 根据HashMap存放 最多全部放入
        HashMap<Integer, Integer> hashMap = new HashMap<>(len);
        int index = 0;
        if (nums[index] < 0 || nums[index] > len-1) {
            return -1;
        }
        hashMap.put(nums[index++], 1);
        while (index < len) {
            if (nums[index] < 0 || nums[index] > len-1) {
                return -1;
            }
            if (hashMap.containsKey(nums[index])) {
                return nums[index];
            }
            // 若不重复则放入
            hashMap.put(nums[index++], 1);
        }
        return -1;
    }

    public static void main(String[] args) throws Exception{
        int[] nums = {52, 35, 51, 77, 19, 10, 27, 37, 54, 26, 75, 9, 71, 81, 76, 75, 21, 100, 54, 50, 87, 40, 21, 87, 18, 23, 58, 12, 17, 84, 11, 6, 91, 73, 57, 19, 85, 65, 36, 44, 40, 77, 33, 56, 27, 48, 77, 59, 8, 65, 77, 13, 9, 52, 53, 9, 77, 73, 85, 33, 31, 10, 84, 94, 4, 13, 82, 12, 91, 89, 93, 40, 42, -100, 85, 36, 20, 33, 13, 48, 38, 93, 30, 87, 47, 44, 29, 47, 33, 52, 36, 55, 20, 29, 68, 58, 64, 5, 15, 26};
        System.out.println(new Solution1().duplicateInArray(nums));
    }
}
