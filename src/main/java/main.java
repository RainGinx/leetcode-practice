import java.util.PriorityQueue;

/**
 * @author caihongbin
 * @date 2021/8/27 16:22
 */
public class main {

    public static void main(String[] args) {
        long before = System.currentTimeMillis();

        MedianFinder finder = new MedianFinder();
        finder.addNum(2);
        finder.addNum(32);
        finder.addNum(4);
        finder.addNum(7);
        finder.addNum(23);
        finder.addNum(45);
        System.out.println(finder.findMedian());
        long after = System.currentTimeMillis();

        System.out.println("用时:"+(after-before) );

    }
}
