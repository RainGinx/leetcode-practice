package easy;

/**
 *
 * 9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author caihongbin
 * @date 2021/9/27 20:11
 */
public class IsPalindrome {

    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        String c = String.valueOf(x);
        int s = 0;
        int e = c.length()-1;
        while (s >= e){
            if (!(c.charAt(s) == c.charAt(e))){
                return false;
            }else {
                s++;
                e--;
            }
        }
        return  true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(211));
    }
}
