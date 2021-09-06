package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 *
 * @author caihongbin
 * @date 2021/9/2 15:32
 */
public class GetKthFromEnd_O22 {

    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode result = null;
        List<Integer> list = new ArrayList<>();
        while (true){
            list.add(head.val);
            if (head.next != null){
                head = head.next;
            }else {
                break;
            }
        }
        for (int i = list.size()-1; i >=0 && i > (list.size() - k -1); i-- ){
            if (result == null){
                result = new ListNode(list.get(i));
            }else {
                ListNode temp = new ListNode(list.get(i));
                temp.next = result;
                result = temp;
            }
        }
        return result;
    }
}
