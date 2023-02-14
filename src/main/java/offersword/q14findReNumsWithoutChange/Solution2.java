package offersword.q14findReNumsWithoutChange;

/**
 * O(1)
 * @author yancy0109
 */
public class Solution2 {
    public int duplicateInArray(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        // 给定n+1个数，出现数字范围则为[1, nums.lengths-1]
        int l = 1, r = nums.length - 1;
        // nums数值区间为 1 -->  n
        while (l < r) {
            // 取区间中点
            int mid = l + r >> 1;  // 划分为: [l, mid] [mid+1, r]
            int s = 0;
            // 记录符合左区间范围的数出现了多少次
            for (int num : nums) {
                if (num >= l && num <= mid) {
                    s++;
                }
            }
            // 出现次数  》  区间范围
            // 重复数在左区间
            if (s > mid - l + 1) {
                r = mid;
                continue;
            }
            // 重复数在右区间
            l = mid + 1;
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 5, 9, 7, 9, 5, 1, 5, 6, 7};
        System.out.println(new Solution2().duplicateInArray(nums));
    }
}
