package leetcodeHot100.q6ConvertZ;

/**
 * @author yancy0109
 */
public class Solution2 {

    private static final int MIN_ROWS = 2;
    public String convert(String s, int numRows) {
        //当行数小于2时，不需要进行转换
        if (numRows < MIN_ROWS){
            return s;
        }


        return null;
    }
    public static void main(String[] args) {
        System.out.println(new Solution2().convert("PAYPALISHIRING",3));
    }
}
