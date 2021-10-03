import java.util.LinkedList;
import java.util.List;

public class MovingAverage {

    List<Integer> array;
    int sum;
    int windowSize;

    public MovingAverage(int size) {
        array = new LinkedList<>();
        sum = 0;
        windowSize = size;
    }

    public double next(int val) {
        sum += val;
        array.add(val);

        if (array.size() > windowSize)
            sum -= array.remove(0);
        return (1.0 * sum) / array.size();
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }
}