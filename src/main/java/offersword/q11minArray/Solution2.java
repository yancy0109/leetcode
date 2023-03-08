package offersword.q11minArray;

/**
 * 二分查找 最小值
 * @author yancy0109
 */
public class Solution2 {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return numbers[0];
        }
        int l = 0;
        int r = len-1;
        int mid;
        // 去除右方与最左方相同的元素 保证为两段非降序队列
        while (numbers[r] == numbers[0] && r > 0) r--;
        while (l < r) {
            mid = l + ((r-l) >> 1);
            // 右方全为升序 最小点在左边
            if (numbers[mid] <= numbers[r]) {
                r = mid;
                continue;
            }
            // 当前点出现逆序 最小点在右边
            l = mid + 1;
        }
        return numbers[l];
    }

    public static void main(String[] args) {
        int[] a = {3,4,5,1,2};
        System.out.println(new Solution2().minArray(a));
    }

}
