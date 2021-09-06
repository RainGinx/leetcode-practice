package middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 1109. 航班预订统计
 * 这里有n个航班，它们分别从 1 到 n 进行编号。
 *
 * 有一份航班预订表bookings ，表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]意味着在从 firsti到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi个座位。
 *
 * 请你返回一个长度为 n 的数组answer，其中 answer[i] 是航班 i 上预订的座位总数。
 *
 *
 * 示例 1：
 *
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5 [10,45,-10,-20,0]
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 * 示例 2：
 *
 * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
 * 输出：[10,25]
 * 解释：
 * 航班编号        1   2
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       15
 * 总座位数：      10  25
 * 因此，answer = [10,25]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/corporate-flight-bookings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author caihongbin
 * @date 2021/8/31 10:06
 */
public class FlightBookings_1109 {


    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] flight = new int[n];
        for (int[] booking : bookings) {
            //计算在flight[booking[0]-1]这趟航班中,booking订单中上机的人数
            flight[booking[0]-1] +=booking[2];
            //计算在flight[booking[1]-1]这趟航班中,booking订单中下机的人数
            if (booking[1] < n){
                flight[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < flight.length; i++) {
            flight[i] += flight[i-1];
        }
        return flight;
    }
}
