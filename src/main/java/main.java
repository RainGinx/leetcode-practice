import easy.Search_704;
import middle.*;

import java.util.PriorityQueue;

/**
 * @author caihongbin
 * @date 2021/8/27 16:22
 */
public class main {

    public static void main(String[] args) {
        long before = System.currentTimeMillis();

       /* MedianFinder finder = new MedianFinder();
        finder.addNum(2);
        finder.addNum(32);
        finder.addNum(4);
        finder.addNum(7);
        finder.addNum(23);
        finder.addNum(45);
        System.out.println(finder.findMedian());*/
        ListNode n1 = null;
        for (int i = 1; i < 10;i++){
            if (n1 == null){
                n1 = new ListNode(i);
            }else {
                ListNode temp = new ListNode(i);
                temp.next = n1;
                n1 = temp;
            }
        }

        GetKthFromEnd_O22 test = new GetKthFromEnd_O22();
        System.out.println( test.getKthFromEnd(n1,3));
        long after = System.currentTimeMillis();

        System.out.println("用时:"+(after-before) );
        System.out.println(Integer.parseInt("0002"));
    }
}
