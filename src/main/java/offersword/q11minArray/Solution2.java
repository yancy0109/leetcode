package offersword.q11minArray;

/**
 * 二分查找 最小值
 * @author yancy0109
 */
public class Solution2 {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        if (len == 1) {
            return numbers[0];
        }
        int l = 0;
        int r = len-1;
        int mid;
        while (l < r) {
            mid = l + ((r-l) >> 1);
            // 出现重复，无法判断分界点位置
            // eg 4 4 4 4 4 1 2 3 4 4 4 4 4 假如 mid 在 1前的4 / 1后的4 结果都会不同
            // 如果mid 与 r 之间没有元素 则分界点在左
            // 中间有元素 则在右
            // 但是去除r位置元素 不影响结果
            if (numbers[mid] == numbers[r]) {
                r--;
                continue;
            }
            // 右方全为升序 最小点在左边
            if (numbers[mid] < numbers[r]) {
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
