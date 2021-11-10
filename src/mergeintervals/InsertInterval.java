package mergeintervals;

import java.util.*;

class InsertInterval {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();

        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start > newInterval.start) {
                intervals.add(i, newInterval);
                break;
            }
        }

        Iterator<Interval> itr = intervals.iterator();
        Interval interval = itr.next();
        int start = interval.start, end = interval.end;

        while (itr.hasNext()) {
            interval = itr.next();
            if (end >= interval.start) {
                end = Math.max(end, interval.end);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }

    /**
     * Time complexity
     * As we are iterating through all the intervals only once,
     * the time complexity of the above algorithm is O(N), where ‘N’ is the total number of intervals.
     * <p>
     * Space complexity
     * The space complexity of the above algorithm will be O(N)
     * as we need to return a list containing all the merged intervals.
     */
    public static List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.isEmpty())
            return Arrays.asList(newInterval);

        List<Interval> mergedIntervals = new ArrayList<>();

        int i = 0;
        // skip (and add to output) all intervals that come before the 'newInterval'
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            mergedIntervals.add(intervals.get(i++));

        // merge all intervals that overlap with 'newInterval'
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }

        // insert the newInterval
        mergedIntervals.add(newInterval);

        // add all the remaining intervals to the output
        while (i < intervals.size())
            mergedIntervals.add(intervals.get(i++));

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}

