package hard;

/**
 * 639. 解码方法 II
 * 一条包含字母 A-Z 的消息通过以下的方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 一条已编码的消息，所有的数字都必须分组，然后按原来的编码方案反向映射回字母（可能存在多种方式）。例如，"11106" 可以映射为：
 *
 * "AAJF" 对应分组 (1 1 10 6)
 * "KJF" 对应分组 (11 10 6)
 * 注意，像 (1 11 06) 这样的分组是无效的，因为 "06" 不可以映射为 'F' ，因为 "6" 与 "06" 不同。
 *
 * 除了 上面描述的数字字母映射方案，编码消息中可能包含 '*' 字符，可以表示从 '1' 到 '9' 的任一数字（不包括 '0'）。例如，编码字符串 "1*" 可以表示 "11"、"12"、"13"、"14"、"15"、"16"、"17"、"18" 或 "19" 中的任意一条消息。对 "1*" 进行解码，相当于解码该字符串可以表示的任何编码消息。
 *
 * 给你一个字符串 s ，由数字和 '*' 字符组成，返回 解码 该字符串的方法 数目 。
 *
 * 由于答案数目可能非常大，返回对 109 + 7 取余 的结果。
 * @author caihongbin
 * @date 2021/9/27 15:23
 */
public class NumDecodings {

    public static int numDecodings(String s) {
        int mod = (int)1e9+7;
        int n = s.length() + 1;
        long[] f = new long[3];
        f[0] = 1;
        f[1] = s.charAt(0) == '*' ? 9 : (s.charAt(0) != '0' ? 1 : 0);
        for (int i = 2; i < n; i++) {
            char c = s.charAt(i - 1), prev = s.charAt(i - 2);
            int p1 = (i - 1) % 3, p2 = (i - 2) % 3;
            long cnt = 0;
            if (c == '*') {
                // cs[i] 单独作为一个 item
                cnt += f[p1] * 9;
                // cs[i] 与前一个字符共同作为一个 item
                if (prev == '*') {
                    cnt += f[p2] * 15;
                } else {
                    int u = (int)(prev - '0');
                    if (u == 1) cnt += f[p2] * 9;
                    else if (u == 2) cnt += f[p2] * 6;
                }
            } else {
                int t = (int)(c - '0');
                if (prev == '*') {
                    if (t == 0) {
                        cnt += f[p2]* 2;
                    } else {
                        // cs[i] 单独作为一个 item
                        cnt += f[p1];
                        // cs[i] 与前一个字符共同作为一个 item
                        if (t <= 6) cnt += f[p2] * 2;
                        else cnt += f[p2];
                    }
                } else {
                    int u = (int)(prev - '0');
                    if (t == 0) {
                        if (u == 1 || u == 2) cnt += f[p2];
                    } else {
                        // cs[i] 单独作为一个 item
                        cnt += f[p1];
                        // cs[i] 与前一个字符共同作为一个 item
                        if (u == 1) cnt += f[p2];
                        else if (u == 2 && t <= 6) cnt += f[p2];
                    }
                }
            }
            f[i % 3] = cnt % mod;
        }
        return (int)(f[(n - 1) % 3]);
    }


    public static void main(String[] args) {
//        System.out.println(numDecodings("1*22"));
        int mod = (int)1e9+7;
        System.out.println( numDecodings("11263172") );
    }
}
