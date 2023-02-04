package leetcodeHot100.q4FindMedianSortedArrays;

/**
 * @author yancy0109
 */
public class Solution2 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //num1长度
        int length1 = nums1.length;
        //num1起始指针
        int index1 = 0;
        //num2长度
        int length2 = nums2.length;
        //num2起始指针
        int index2 = 0;
        //总长度
        int lengthTotal = length1 + length2;
        int before = 0;
        //循环比较两个指针位置，如何达到中位数点？ ---->>>  通过指针位置
        while (true){
            //指针已经比较过的长度
            before = (length1 - index1 +1 ) + (length1 - index1 +1 );
            if (lengthTotal / 2 == before){
                break;
            }
            //指针害妹飞出去
            if (index1 < length1 - 1 && index2 < length2 -1 ){
                if (nums1[index1] < nums2[index2]){
                    index1++;
                }else {
                    index2++;
                }
            }
        }
        //总长度为偶数
        if (lengthTotal % 2 == 0){
            if (before == lengthTotal / 2){

            }
        }
        //总长度为奇数
        if(lengthTotal %2 != 0){
            if (before == lengthTotal / 2){

            }
        }//总长度为偶数
        if (lengthTotal % 2 == 0){
            if (before == lengthTotal / 2){

            }
        }
        //总长度为奇数
        if(lengthTotal %2 != 0){
            if (before == lengthTotal / 2){

            }
        }
        return 1/2.0;
    }

    public static void main(String[] args) {
        int [] nums1 = {1,2};
        int [] nums2 = {3,4,5,6};
        double median = new Solution2().findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }
}
