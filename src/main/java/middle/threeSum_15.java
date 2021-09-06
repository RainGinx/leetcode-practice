package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 5. 三数之和
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author caihongbin
 * @date 2021/8/31 17:56
 */
public class threeSum_15 {

    /**
     * 本地运行结果和力扣的预期结果一致，但是在力扣上运行的输出结果却不一致
     * 双指针+排序
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int zero = 0;
        int min = 0;
        int max = length-1;
        while (min <= max){
            if (nums[min] >=0){
                zero = min;
                break;
            }else {
                min++;
            }

            if (nums[max] < 0){
                zero = max+1;
                break;
            }else if (nums[max] == 0){
                zero = max;
                break;
            }else {
                max--;
            }
        }

        for (int i = 0; i <= zero; i++) {
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i+1; j < length-1; j++) {
                if (j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
               int third = length-1;
               while (j < third){
                   if (nums[i] + nums[j] + nums[third] == 0){
                       result.add( Arrays.asList(nums[i],nums[j],nums[third]) );
                       break;
                   }
                   third--;
               }

            }
        }
        return  result;
    }
}
