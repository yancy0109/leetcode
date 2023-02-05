package leetcodeHot100.q4FindMedianSortedArrays;

/**
 * @author yancy0109
 */
public class App {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 记录长度
        int lengthA = nums1.length;
        int lengthB = nums2.length;
        // 合并数组总长度
        int lengthTotal = lengthA + lengthB;
        int[] resultArray = new int[lengthTotal];
        int resultIndex = 0;
        int indexA = 0;
        int indexB = 0;
        // 当两个数组都包含元素
        if (lengthA != 0 && lengthB != 0) {
            while (true) {
                // 比较赋予更小的值
                resultArray[resultIndex++] =  nums1[indexA] < nums2[indexB] ? nums1[indexA++] : nums2[indexB++];
                // 数组A/B遍历完成
                if(indexA == lengthA || indexB == lengthB) {
                    break;
                }
            }
        }
        // 判断谁先结束，再继续步骤
        // 使用Resolve指代未处理完成的数组，减少代码量
        // 待处理数组
        int[] resolve = indexB == lengthB  ? nums1 : nums2;
        // 待处理数组总长度
        int resolveLength = indexB == lengthB  ? lengthA : lengthB;
        // 待处理数组当前Index
        int resolveIndex = indexB == lengthB  ? indexA : indexB;
        // 遍历未合并的元素
        for (; resolveIndex < resolveLength; resolveIndex++) {
            resultArray[resultIndex++] = resolve[resolveIndex];
        }
        double returnNum;
        // 总长为偶数
        if (lengthTotal % 2 == 0) {
            returnNum = (resultArray[(lengthTotal >> 1)] + resultArray[(lengthTotal >> 1) -1]) / 2.0;
        } else {
            // 总长为奇数
            returnNum = resultArray[lengthTotal >> 1] ;
        }
        return returnNum;
    }

    public static void main(String[] args) {
        int [] nums1 = {1,2,5,6};
        int [] nums2 = {};
        double median = new App().findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }
}
