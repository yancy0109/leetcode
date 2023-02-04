package leetcodeHot100.q1twoSum;


import java.util.HashMap;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        //创建Hash表 最长为length-1 ---> 最后一个元素不需要存入HashMap中比较
        HashMap<Integer,Integer> hashMap = new HashMap<>(length-1);
        //将首元素放入Hash表
        hashMap.put(nums[0],0);
        for (int i = 1; i < length; i++){
            //计算所需另一个元素的值
            int annother = target - nums[i];
            if (hashMap.containsKey(annother)){
                //如果HashMap中存在annother 返回两个元素的位置
                return new int[]{hashMap.get(annother),i};
            }
            //不存在则把当前元素也放入HashMap
            hashMap.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] ints = new Solution1().twoSum(nums, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}
