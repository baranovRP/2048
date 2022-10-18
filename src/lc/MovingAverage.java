package lc;

public class MovingAverage {

    int currentSum;
    CircularQueue window;
    int counter;
    int size;

    public MovingAverage(int size) {
        window = new CircularQueue(size);
        currentSum = 0;
        counter = 0;
        this.size = size;
    }

    public double next(int val) {
        if (counter < size) {
            counter++;
        } else {
            currentSum -= window.Front();
            window.deQueue();
        }
        window.enQueue(val);
        currentSum += val;

        return (double) currentSum / counter;
    }

    public static void main(String[] args) {
/*
        MovingAverage movingAverage = new MovingAverage(3);
        movingAverage.next(1); // return 1.0 = 1 / 1
        movingAverage.next(10); // return 5.5 = (1 + 10) / 2
        movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
        movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
*/
        MovingAverage movingAverage = new MovingAverage(1);
        System.out.println(movingAverage.next(4));
        System.out.println(movingAverage.next(0));
    }
}
