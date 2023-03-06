package offersword.q11minArray;

/**
 * 二分查找 分界点
 * @author yancy0109
 */
public class Solution3 {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        if (len == 1) {
            return numbers[0];
        }
        int l = 0;
        int r = len-1;
        int mid;
        while (numbers[r] == numbers[0] && r > 0) r--;
        // 如果单调
        if (numbers[r] > numbers[0]) return numbers[0];
        while (l < r) {
            mid = l + ((r-l) >> 1); // l,mid  [mid+1,r
            // 分界点在mid右方
            if (numbers[mid] >= numbers[0]) {
                l = mid + 1;
            } else {
                // 分解点在mid
                r = mid;
            }
        }
        return numbers[l];
    }

    public static void main(String[] args) {
        int[] a = {10,1,10,10,10};
        System.out.println(new Solution3().minArray(a));
    }

}
