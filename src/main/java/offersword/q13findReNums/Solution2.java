package offersword.q13findReNums;

import java.util.HashMap;

/**
 * 13. 找出数组中重复的数字
 * 原地交换
 * @author yancy0109
 */
public class Solution2 {
    public int duplicateInArray(int[] nums) {
        int len = nums.length;
        // 空数组则返回
        if (len == 0) {
            return -1;
        }
        // 遍历每一个元素，每个位置都将处于合适位置
        int i = 0;
        while (i < len){
            // 元素处在自己的位置
            if (nums[i] == i) {
                i++;
                continue;
            }
            // -->  将元素挪至对应位置
            // 如果对应位置存在与它相符的元素，则return -1
            if (nums[nums[i]] == nums[i]) {
                // Maybe nums[i] < i || nums[i] > i
                return nums[i];
            }
            // 将当前元素挪至对应位置，当temp位置【该位置必然>i，如果小于i则已重复】的元素挪至当前位置
            // 等待下次循环将其挪至合适位置
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception{
        int[] nums = {3, 1, -10, 1, 1, 4, 3, 10, 1, 1};
        System.out.println(new Solution2().duplicateInArray(nums));
        System.out.println();
    }
}
