package others.q6ConvertZ;

/**
 * @author yancy0109
 */
public class Solution2 {

    public String convert(String s, int numRows) {
        //当行数小于2时，不需要进行转换
//        if (numRows < 2){
//            return s;
//        }
        // 每行存储结果
        StringBuffer[] res = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = new StringBuffer();
        }
        int length = s.length();
        if (length == 1) {
            return s;
        }
        char[] charArray = s.toCharArray();
        // 遍历输入String
        int index = 0;
        // 行指针  --》  当前所在行
        int rowIndex = 0;
        while (index < length) {
            // 向下
            while (index < length && rowIndex < numRows) {
                res[rowIndex++].append(charArray[index++]);
            }
            // 行标重置 Eg rowIndex = 3 (numRows = 3)  -->   rowIndex = 1
            rowIndex-=2;
            // 向上
            while (index < length && rowIndex >= 0) {
                res[rowIndex--].append(charArray[index++]);
            }
            // 行标重置 Eg rowIndex = -1 (numRows = 3)  -->   rowIndex = 1
            rowIndex+=2;
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < numRows; i++){
            buffer.append(res[i]);
        }
        return buffer.toString();
    }
    public static void main(String[] args) {
        System.out.println(new Solution2().convert("PAYPALISHIRING",1));
    }
}
