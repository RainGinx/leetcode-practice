package middle;

/**
 * @author caihongbin
 * @date 2021/9/6 10:51
 */
public class SearchRange_34 {

//    双循环
     public int[] solution(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        int start = 0;
        int end = nums.length-1;
        while (start<nums.length-1){
            if (nums[start] == target){
                result[0] = start;
                break;
            }else {
                start++;
            }
        }
         while (end>=0){
             if (nums[end] == target){
                 result[1] = end;
                 break;
             }else {
                 end--;
             }
         }
        return result;
    }
//    二分法
    public int[] solution2(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid = start+(end-start>>1);
            if (nums[mid] == target){
                for (int n1 = 0; n1 < mid; n1++){
                    if (nums[mid-n1] < target){
                        result[0] = mid-n1+1;
                        break;
                    }
                }
                for (int n1 = 0; n1 < nums.length-mid; n1++){
                    if (nums[mid+n1] > target){
                        result[1] = mid+n1-1;
                        break;
                    }
                }
                break;
            }
            if (nums[mid] > target){
                end = mid -1;
            }
            if (nums[mid] < target){
                start = mid+1;
            }
        }
        return result;
    }

}
