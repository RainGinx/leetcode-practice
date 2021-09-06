package middle;

/**
 * @author caihongbin
 * @date 2021/8/31 16:05
 */
public class MaxArea_11 {

    public int maxArea(int[] height) {
        int length = height.length;
        int min = 0;
        int max = length-1;
        int area = 0;
        while (min<max){
            int h = Math.min(height[min],height[max]);
            int temp = (max-min)*h;
            if (temp > area) {
                area = temp;
            }
            if (height[min] > height[max]){
                max--;
            }else {
                min++;
            }
        }
        return area;
    }
}
