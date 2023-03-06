package offersword.q11minArray;

/**
 * 迭代解法
 * @author yancy0109
 */
public class Solution1 {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        if (len == 1) {
            return numbers[0];
        }
        int index = 1;
        while (index < len) {
            if (numbers[index] < numbers[index-1]) {
                return numbers[index];
            }
            index++;
        }
        return numbers[0];
    }

    public static void main(String[] args) {
        int[] a = {3,4,5,1,2};
        System.out.println(new Solution1().minArray(a));
    }

}
