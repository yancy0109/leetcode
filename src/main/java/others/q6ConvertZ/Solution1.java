package others.q6ConvertZ;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yancy0109
 */
public class Solution1 {

    private static final int MIN_ROWS = 2;
    public String convert(String s, int numRows) {
        //当行数小于2时，不需要进行转换
        if (numRows < MIN_ROWS){
            return s;
        }
        List<StringBuffer> rows = new ArrayList<>();
        //行存储
        for (int i = 0 ; i < numRows; i++){
            rows.add(new StringBuffer());
        }
        //行指针
        int index = 0;
        //flag代表在Z字排序中的正负方向 --》 代表了Z字循环的方向
        int flag = -1;
        //循环字符串
        for (char c : s.toCharArray()) {
            rows.get(index).append(c);
            if (index == 0 || index == numRows - 1){
                //调转flag方向
                flag = -flag;
            }
            //行指针变换 ---》 通过flag指示了方向进行变换
            index += flag;
        }
        StringBuffer res = new StringBuffer();
        for (StringBuffer row : rows) {
            res.append(row.toString());
        }
        return res.toString();
    }
    public static void main(String[] args) {
        System.out.println(new Solution1().convert("PAYPALISHIRING",3));
    }
}
