package offersword.q14findReNumsWithoutChange;

/**
 * O(n)
 * @author yancy0109
 */
public class Solution1 {
    public int duplicateInArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        int[] record = new int[len+1];
        int index = 0;
        while (index < len) {
            if (record[nums[index]] != 0) {
                return nums[index];
            }
            record[nums[index++]]++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(new Solution1().duplicateInArray(nums));
    }
}
