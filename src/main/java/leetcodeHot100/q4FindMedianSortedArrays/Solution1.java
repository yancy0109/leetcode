package leetcodeHot100.q4FindMedianSortedArrays;

public class Solution1 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] result = new int[length1+length2];
        int indexForResult = 0;
        int index1 = 0;
        int index2 = 0;
        if (length1 != 0 && length2 != 0){
            while (true){
                if (nums1[index1] < nums2[index2]){
                    result[indexForResult++]=nums1[index1];
                    index1++;
                }else {
                    result[indexForResult++]=nums2[index2];
                    index2++;
                }
                if (length1 == index1 || length2 == index2){
                    break;
                }
            }
        }
        if (length1 == index1){
            for (; index2 < length2; index2++){
                result[indexForResult++]=nums2[index2];
            }
        }
        if (length2 == index2){
            for (; index1 < length1; index1++){
                result[indexForResult++]=nums1[index1];
            }
        }
        int size = result.length;
        if (size % 2 == 0){
            return (result[size / 2 + 1 - 1] + result[size / 2 - 1])/2.0;
        }else {
            return result[size/2] / 1.0;
        }
    }

    public static void main(String[] args) {
        int [] nums1 = {1,2};
        int [] nums2 = {3,4};
        double median = new Solution1().findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }
}
