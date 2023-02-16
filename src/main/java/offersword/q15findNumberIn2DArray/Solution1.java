package offersword.q15findNumberIn2DArray;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * @author yancy0109
 */
public class Solution1 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 总长度
        int rowLen = matrix.length;
        if (rowLen == 0) {
            return false;
        }
        int lineLen = matrix[rowLen - 1].length;
        // 行列指针
        int rowIndex = 0;
        int lineIndex = lineLen - 1;
        while (rowIndex < rowLen && lineIndex >= 0){
            int indexNum = matrix[rowIndex][lineIndex];
            if (indexNum == target) {
                // 当前处于目标位置
                return true;
            }
            if (target > matrix[rowIndex][lineIndex]) {
                // 目标在当前Index所在行的下方
                rowIndex++;
            } else {
                // 目标在当前Index所在列的左方
                lineIndex--;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = {
            {-5},
        };
        System.out.println(new Solution1().findNumberIn2DArray(matrix, -5));
    }
}
