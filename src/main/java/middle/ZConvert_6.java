package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author caihongbin
 * @date 2021/8/30 16:39
 */
public class ZConvert_6 {

    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        int loop = 2*numRows-2;
        List<StringBuilder> temp = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            temp.add(new StringBuilder());
        }
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            int index = i%loop;
            if (index < numRows){
                temp.get(index).append(c[i]);
            }else {
                temp.get(2*(numRows-1)-index).append(c[i]);
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : temp) {
            result.append(stringBuilder);
        }
        return result.toString();
    }
}
