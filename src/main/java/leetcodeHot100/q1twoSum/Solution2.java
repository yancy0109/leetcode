package leetcodeHot100.q1twoSum;

public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        //数组长度
        int length = nums.length;
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){
                if (j==i) continue;
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5, -8};
        int target = -8;
        int[] ints = new Solution2().twoSum(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
