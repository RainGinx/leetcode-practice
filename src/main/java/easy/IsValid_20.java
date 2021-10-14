package easy;

import java.util.*;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author caihongbin
 * @date 2021/9/7 16:44
 */
public class IsValid_20 {

    public static boolean isValid(String s) {
        List<Character> cs = new ArrayList<>();
        char[] c = s.toCharArray();
        for (char c1 : c) {
            if (c1 == '(' || c1 == '[' || c1 == '{'){
                cs.add(c1);
            }else {
                if (cs.isEmpty()){
                    return false;
                }
                if (c1 == '}' && cs.get(cs.size()-1) == '{'){
                    cs.remove(cs.size()-1);
                }else if (c1 == ']' && cs.get(cs.size()-1) == '['){
                    cs.remove(cs.size()-1);
                }else if (c1 == ')' && cs.get(cs.size()-1) == '('){
                    cs.remove(cs.size()-1);
                }else {
                    cs.add(c1);
                }
            }
        }
       return cs.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("".replace("123","456"));
    }

}
