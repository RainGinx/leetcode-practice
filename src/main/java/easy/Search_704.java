package easy;

import java.util.Arrays;

/**
 * 704. 二分查找
 *
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author caihongbin
 * @date 2021/9/6 9:53
 */
public class Search_704 {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid = start + (end-start>>1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target){
                start = mid+1;
            }
            if (nums[mid] > target){
                end = mid -1;
            }
        }
        return -1;
    }
}
