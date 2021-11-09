package mergeintervals;

import java.util.*;

public class OverLappingInterval {

    /**
     * Time complexity
     * The time complexity of the above algorithm is O(N∗logN),
     * where ‘N’ is the total number of intervals. We are iterating the intervals only once which will take O(N),
     * in the beginning though, since we need to sort the intervals, our algorithm will take O(N∗logN).
     * <p>
     * Space complexity
     * The space complexity of the above algorithm will be O(N)
     * as we need to return a list containing all the merged intervals.
     * We will also need O(N) space for sorting.
     * For Java, depending on its version, Collections.sort() either uses Merge sort or Timsort,
     * and both these algorithms need O(N) space.
     * Overall, our algorithm has a space complexity of O(N).
     */
    public static boolean isOverlapping(List<Interval> intervals) {
        if(intervals.size()<2) return false;

        intervals.sort(Comparator.comparingInt(a -> a.start));
        Iterator<Interval> intervalIterator=intervals.iterator();
        Interval interval = intervalIterator.next();
        int end=interval.end;

        while (intervalIterator.hasNext()) {
            interval = intervalIterator.next();
            if(interval.start <= end) return true;
            else {
                end = interval.end;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Is Overlapping: ");
        System.out.println(OverLappingInterval.isOverlapping(input));
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Is Overlapping: ");
        System.out.println(OverLappingInterval.isOverlapping(input));
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Is Overlapping: ");
        System.out.println(OverLappingInterval.isOverlapping(input));
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(5, 6));
        System.out.print("Is Overlapping: ");
        System.out.println(OverLappingInterval.isOverlapping(input));
        System.out.println();
    }
}
