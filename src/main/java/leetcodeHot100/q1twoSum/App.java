package leetcodeHot100.q1twoSum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author yancy0109
 */
public class App {
    public int[] twoSum(int[] nums, int target) {
        // 数组长度
        int length = nums.length;
        // 采用HashMap映射方式降低复杂度  空间换时间
        // length-1 ----> 当循环至数组最后一位，不需要再放入HashMap中了
        HashMap<Integer, Integer> hashMap = new HashMap<>(length-1);
        hashMap.put(nums[0], 0);
        for (int i = 1; i < length; i++) {
            // 目标值大小
            int targetNum = target - nums[i];
            // HashMap存在目标值，则返回
            if (hashMap.containsKey(targetNum)) {
                return new int[] {hashMap.get(targetNum), i};
            }
            // 不存在则把当前数放入HashMap
            hashMap.put(nums[i], i);
        }
        // 未找到，返回空数组
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {12,2,5};
        int[] ints = new App().twoSum(nums, 3);
        ints = new int[0];
        for (int i : ints) {
            System.out.print(i + " ");
        }

    }
}
