import easy.Search_704;
import middle.*;

import java.util.*;

/**
 * @author caihongbin
 * @date 2021/8/27 16:22
 */
public class main {

    public static void main(String[] args) {

        String s = "{rdName}:\n        你好！\n      123123";
        s = s.replaceAll("\\n","<br>");
        System.out.println(s);
    }
    public static int getSum(int a, int b) {
        int ans = 0;
        // 存储进位
        int carry = 0;
        for (int i = 0; i < 32; i++) {
            // 从低位到高位依次计算
            int x = (a >> i) & 1;
            int y = (b >> i) & 1;
            if (x == 1 && y == 1) {
                // 不管carry是啥，肯定有进位
                ans |= carry << i;
                carry = 1;
            } else if (x == 1 || y == 1) {
                // carry为1则有进位，carry为0则无进位，与现有的carry一致
                ans |= (carry ^ 1) << i;
            } else {
                // 不管carry是啥，肯定没有进位
                ans |= carry << i;
                carry = 0;
            }
        }
        return ans;
    }
}
