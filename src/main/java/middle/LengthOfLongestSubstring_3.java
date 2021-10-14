package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author caihongbin
 * @date 2021/9/7 17:51
 */
public class LengthOfLongestSubstring_3 {

    public static int solution(String s){
        List<Character> list = new ArrayList<>();
        char[] c = s.toCharArray();
        int l = 0;
        for (int i = 0; i < c.length;) {
            int j = i;
            while (j<c.length){
                if ( list.contains(c[j]) ){
                    if (list.size() >= l){
                        l=list.size();
                        list.clear();
                        break;
                    }
                }else {
                    list.add(c[j]);
                }
                j++;
            }
            i=j;
        }
        return list.size() > l?list.size():l;
    }

    public static void main(String[] args) {
        System.out.println(solution("aab"));
    }
}
